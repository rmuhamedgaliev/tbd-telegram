package dev.tobee.telegram.demo;

import dev.tobee.telegram.client.TelegramApiClient;
import dev.tobee.telegram.model.message.Update;

import java.util.concurrent.Flow;

public abstract class BaseSubscriber implements Flow.Subscriber<Update> {

    protected final TelegramApiClient client;

    private Flow.Subscription subscription;

    protected BaseSubscriber(TelegramApiClient client) {
        this.client = client;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Update item) {
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throw new RuntimeException("Error on handle message");
    }

    @Override
    public void onComplete() {
    }
}
