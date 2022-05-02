package dev.tobee.telegram;

import dev.tobee.telegram.model.message.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Flow;

public class UpdateSubscriber implements Flow.Subscriber<Update> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateSubscriber.class);
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        LOGGER.info("New subscription to UpdateSubscriber ");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Update item) {
        LOGGER.debug("Received new update with id {}", item.updateId());
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        LOGGER.error("Error on processing update ", e);
    }

    @Override
    public void onComplete() {
        LOGGER.info("Complete processing");
    }
}
