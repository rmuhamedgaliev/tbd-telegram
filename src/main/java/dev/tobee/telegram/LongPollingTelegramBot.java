package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.Update;
import dev.tobee.telegram.model.UpdateTypes;
import dev.tobee.telegram.request.GetUpdateBody;
import dev.tobee.telegram.request.GetUpdates;
import dev.tobee.telegram.request.Request;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LongPollingTelegramBot implements TelegramBot {

    private final ScheduledExecutorService executorService;

    private final OptionalInt initialDelay = OptionalInt.empty();

    private final OptionalInt period = OptionalInt.empty();

    private final TbdAsyncClient tbdTGReactorClient;

    private final SubmissionPublisher<Update> publisher = new SubmissionPublisher<>();

    private final UpdateSubscriber subscriber;

    public LongPollingTelegramBot(String host, String token, ScheduledExecutorService executorService,
                                  UpdateSubscriber subscriber) {
        this.tbdTGReactorClient = new TbdAsyncClient(true, host, token);
        this.executorService = executorService;
        this.subscriber = subscriber;
        this.publisher.subscribe(subscriber);
    }

    public LongPollingTelegramBot(String host, String token, UpdateSubscriber subscriber) {
        this.tbdTGReactorClient = new TbdAsyncClient(true, host, token);
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.subscriber = subscriber;
        this.publisher.subscribe(subscriber);
    }

    @Override
    public void subscribeToUpdate() {

        AtomicInteger lastUpdate = new AtomicInteger();

        executorService.scheduleAtFixedRate(() -> {
                    try {
                        Request<ResponseWrapper<List<Update>>> request;

                        if (lastUpdate.get() > 0) {
                            request = new GetUpdates(Optional.of(new GetUpdateBody(
                                    OptionalInt.of(lastUpdate.get()),
                                    OptionalInt.empty(),
                                    OptionalInt.empty(),
                                    List.of(UpdateTypes.MESSAGE, UpdateTypes.CALLBACK_QUERY, UpdateTypes.CHANNEL_POST)
                            )));
                        } else {
                            request = new GetUpdates(Optional.empty());
                        }

//                    TODO: Обработка ошибок

                        tbdTGReactorClient.getRequest(request)
                                .thenApplyAsync(ResponseWrapper::result)
                                .thenApplyAsync(result -> {
                                    result.stream().flatMap(Collection::stream).forEach(publisher::submit);
                                    return getLastUpdateFromResponse(result);
                                }).thenAcceptAsync(update -> handleLastUpdateId(update, lastUpdate));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                },
                initialDelay.orElse(0),
                period.orElse(getDefaultPeriodInMilliseconds()),
                TimeUnit.MILLISECONDS
        );
    }

    private Optional<Update> getLastUpdateFromResponse(Optional<List<Update>> lastUpdate) {
        Optional<Update> lastUpdateObj = Optional.empty();

        if (lastUpdate.isPresent() && lastUpdate.get().size() > 0) {
            lastUpdateObj = Optional.ofNullable(lastUpdate.get().get(lastUpdate.get().size() - 1));
        }
        return lastUpdateObj;
    }

    private void handleLastUpdateId(Optional<Update> update, AtomicInteger lastUpdate) {
        if (update.isPresent()) {

            if (lastUpdate.get() == update.get().updateId().orElse(0)) {
                lastUpdate.incrementAndGet();
            }

            if (lastUpdate.get() < update.get().updateId().orElse(0)) {
                update.get().updateId().ifPresent(lastUpdate::set);
            }
        } else {
            lastUpdate.set(0);
        }
    }

    private int getDefaultPeriodInMilliseconds() {
        Random random = new Random();

        int min = 500;
        int max = 1000;

        return random.nextInt(max) + min;
    }
}
