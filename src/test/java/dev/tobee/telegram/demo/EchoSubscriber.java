package dev.tobee.telegram.demo;

import dev.tobee.telegram.client.TelegramApiClient;
import dev.tobee.telegram.model.message.Update;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.message.SendMessage;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.Flow;

public class EchoSubscriber implements Flow.Subscriber<Update> {

    private final TelegramApiClient asyncClient;
    private Flow.Subscription subscription;

    public EchoSubscriber(TelegramApiClient asyncClient) {
        this.asyncClient = asyncClient;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Update item) {
        asyncClient.postRequest(new SendMessage(new SendMessageBody(
                item.message().orElseThrow().chat().id(),
                item.message().orElseThrow().text().orElseThrow(),
                Optional.empty(),
                Collections.emptyList(),
                Optional.empty(),
                Optional.of(Boolean.FALSE),
                Optional.empty(),
                item.message().orElseThrow().messageId(),
                Optional.empty(),
                Optional.empty()
        )));
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
