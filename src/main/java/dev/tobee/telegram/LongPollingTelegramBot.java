package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.Update;
import dev.tobee.telegram.model.UpdateTypes;
import dev.tobee.telegram.request.GetUpdates;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetUpdateBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class LongPollingTelegramBot implements TelegramBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(LongPollingTelegramBot.class);

    private final ScheduledExecutorService executorService;

    private final OptionalInt initialDelay = OptionalInt.empty();

    private final OptionalInt period = OptionalInt.empty();

    private final TbdAsyncClient tbdTGReactorClient;

    private final SubmissionPublisher<Update> publisher = new SubmissionPublisher<>();

    public LongPollingTelegramBot(TbdAsyncClient tbdTGReactorClient, Flow.Subscriber<Update> subscriber) {
        this.tbdTGReactorClient = tbdTGReactorClient;
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.publisher.subscribe(subscriber);
    }

    public LongPollingTelegramBot(String host, String token, ScheduledExecutorService executorService,
                                  Flow.Subscriber<Update> subscriber) {
        this.tbdTGReactorClient = new TbdAsyncClient(true, host, token);
        this.executorService = executorService;
        this.publisher.subscribe(subscriber);
    }

    public LongPollingTelegramBot(String host, String token, Flow.Subscriber<Update> subscriber) {
        this.tbdTGReactorClient = new TbdAsyncClient(true, host, token);
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.publisher.subscribe(subscriber);
    }

    @Override
    public void subscribeToUpdate() {

        AtomicLong lastUpdate = new AtomicLong();

        executorService.scheduleAtFixedRate(() -> {
                    try {
                        Request<ResponseWrapper<List<Update>>> request;

                        if (lastUpdate.get() > 0) {
                            request = new GetUpdates(Optional.of(new GetUpdateBody(
                                    OptionalLong.of(lastUpdate.get()),
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
                        LOGGER.error("Error on receive update", e);
                    }

                },
                initialDelay.orElse(0),
                period.orElse(getDefaultPeriodInMilliseconds()),
                TimeUnit.SECONDS
        );
    }

    private Optional<Update> getLastUpdateFromResponse(Optional<List<Update>> lastUpdate) {
        Optional<Update> lastUpdateObj = Optional.empty();

        if (lastUpdate.isPresent() && !lastUpdate.orElseThrow().isEmpty()) {
            lastUpdateObj = Optional.ofNullable(lastUpdate.get().get(lastUpdate.get().size() - 1));
        }
        return lastUpdateObj;
    }

    private void handleLastUpdateId(Optional<Update> update, AtomicLong lastUpdate) {
        if (update.isPresent()) {
            lastUpdate.set(update.get().updateId().orElse(0) + 1);
        } else {
            lastUpdate.set(0);
        }
    }

    private int getDefaultPeriodInMilliseconds() {
        SecureRandom random = new SecureRandom();

        int min = 2;
        int max = 5;

        return random.nextInt(max) + min;
    }

    @Override
    public TbdAsyncClient getClient() {
        return tbdTGReactorClient;
    }
}
