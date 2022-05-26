package dev.tobee.telegram.demo;

import dev.tobee.telegram.client.TelegramApiClient;
import dev.tobee.telegram.model.message.Update;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.message.SendMessage;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.Flow;

public class EchoSubscriber extends BaseSubscriber implements Flow.Subscriber<Update> {

    protected EchoSubscriber(TelegramApiClient client) {
        super(client);
    }

    @Override
    public void onNext(Update item) {
        item.message().flatMap(message -> message.text().filter(text -> text.startsWith("/echo"))).ifPresent(command -> {
                    var message = command.substring(command.indexOf(" ") + 1);
                    client.postRequest(new SendMessage(new SendMessageBody(
                            item.message().orElseThrow().chat().id(),
                            message,
                            Optional.empty(),
                            List.of(),
                            Optional.empty(),
                            Optional.empty(),
                            Optional.empty(),
                            OptionalLong.empty(),
                            Optional.empty(),
                            Optional.empty()
                    )));
                }
        );
        super.onNext(item);
    }
}
