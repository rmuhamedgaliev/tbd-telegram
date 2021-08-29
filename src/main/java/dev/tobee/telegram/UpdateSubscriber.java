package dev.tobee.telegram;

import dev.tobee.telegram.model.Update;

import java.util.concurrent.Flow;

public class UpdateSubscriber implements Flow.Subscriber<Update> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed");
        this.subscription = subscription;
        this.subscription.request(1); //requesting data from publisher
        System.out.println("onSubscribe requested 1 item");
    }

    @Override
    public void onNext(Update item) {
        System.out.println("Processing Employee " + item.updateId());
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("Some error happened");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All Processing Done");
    }
}
