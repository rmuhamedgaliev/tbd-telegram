package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdTGReactorClient;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.Update;
import dev.tobee.telegram.request.GetUpdates;
import dev.tobee.telegram.request.Request;

import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class LongPollingTelegramBot implements TelegramBot {

    private final String host;

    private final String token;

    private final ScheduledExecutorService executorService;

    private final OptionalInt initialDelay = OptionalInt.empty();

    private final OptionalInt period = OptionalInt.empty();

    private final TbdTGReactorClient tbdTGReactorClient = new TbdTGReactorClient();

    private final SubmissionPublisher<Update> publisher = new SubmissionPublisher<>();

    public LongPollingTelegramBot(String host, String token, ScheduledExecutorService executorService,
                                  Flow.Subscriber<Update> subscriber) {
        this.host = host;
        this.token = token;
        this.executorService = executorService;
        this.publisher.subscribe(subscriber);
    }

    public LongPollingTelegramBot(String host, String token,
                                  Flow.Subscriber<Update> subscriber) {
        this.host = host;
        this.token = token;
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.publisher.subscribe(subscriber);
    }

    @Override
    public void subscribeToUpdate() {
        executorService.scheduleAtFixedRate(() -> {
                    Request<ResponseWrapper<List<Update>>> request = new GetUpdates(this.host, this.token);

                    tbdTGReactorClient.getRequest(request)
                            .thenAcceptAsync(response -> {
                                response.result().get().forEach(publisher::submit);
                            });
                },
                initialDelay.orElse(0),
                period.orElse(getDefaultPeriodInMilliseconds()),
                TimeUnit.MILLISECONDS
        );
    }

    private int getDefaultPeriodInMilliseconds() {
        Random random = new Random();

        int min = 500;
        int max = 1000;

        return random.nextInt(max) + min;
    }
}
