package dev.tobee.telegram;

import java.util.Arrays;
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

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.model.message.Update;
import dev.tobee.telegram.model.message.UpdateTypes;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetUpdateBody;
import dev.tobee.telegram.request.chat.GetUpdates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongPollingTelegramBot implements TelegramBot {
    private static final Logger logger = LoggerFactory.getLogger(LongPollingTelegramBot.class);
    private final ScheduledExecutorService executorService;
    private final OptionalInt initialDelay = OptionalInt.empty();
    private final OptionalInt period = OptionalInt.empty();
    private final TbdAsyncClient tbdTGReactorClient;
    private final SubmissionPublisher<Update> publisher = new SubmissionPublisher<>();
    boolean status = true;

    public LongPollingTelegramBot(TbdAsyncClient tbdTGReactorClient, List<Flow.Subscriber<Update>> subscribers) {
        this.tbdTGReactorClient = tbdTGReactorClient;
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        subscribers.forEach(this.publisher::subscribe);
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
                                    Arrays.asList(UpdateTypes.values())
                            )));
                        } else {
                            request = new GetUpdates(Optional.empty());
                        }

                        Optional<List<Update>> updates = tbdTGReactorClient.getRequestSync(request).result();
                        updates.stream().flatMap(Collection::stream).forEach(publisher::submit);
                        Optional<Update> lastUpdateObj = getLastUpdateFromResponse(updates);
                        handleLastUpdateId(lastUpdateObj, lastUpdate);
                    } catch (Exception e) {
                        logger.error("Error on receive update", e);
                    }
                },
                initialDelay.orElse(1),
                period.orElse(1),
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
        update.ifPresent(value -> lastUpdate.set(value.updateId() + 1));
    }

    @Override
    public TbdAsyncClient getClient() {
        return tbdTGReactorClient;
    }
}
