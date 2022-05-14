package dev.tobee.telegram.demo;

import dev.tobee.telegram.client.TelegramApiClient;
import dev.tobee.telegram.model.message.Update;
import dev.tobee.telegram.service.MessageService;

import java.util.concurrent.Flow;

public class EchoSubscriber extends BaseSubscriber implements Flow.Subscriber<Update> {

    private final MessageService messageService;

    protected EchoSubscriber(TelegramApiClient client) {
        super(client);
        messageService = new MessageService(client);
    }

    @Override
    public void onNext(Update item) {
        item.message().flatMap(message -> message.text().filter(text -> text.startsWith("/echo"))).ifPresent(command -> {
                    var message = command.substring(command.indexOf(" ") + 1);
                    messageService.sendReplyToMessage(item.message().orElseThrow().chat().id(),message, item.message().orElseThrow().messageId());
                }
        );
        super.onNext(item);
    }
}
