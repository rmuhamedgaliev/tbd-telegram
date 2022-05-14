package dev.tobee.telegram.service;

import dev.tobee.telegram.client.TelegramApiClient;
import dev.tobee.telegram.model.keyboard.InlineKeyboardButton;
import dev.tobee.telegram.model.keyboard.InlineKeyboardMarkup;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.message.SendMessage;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.CompletableFuture;

/**
 * Service class for send inline request linke buttons
 *
 * @author <a href="mailto:rinat.muhamedgaliev@gmail.com">Rinat Muhamedgaliev</a>
 */
public record InlineKeyboardService(TelegramApiClient client) {

    public CompletableFuture<ResponseWrapper<Message>> sendInlineKeyboard(long chatId, String message) {
        var textMessage = new SendMessageBody(
                chatId,
                message,
                Optional.empty(),
                Collections.emptyList(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                OptionalLong.empty(),
                Optional.empty(),
                Optional.of(
                        new InlineKeyboardMarkup(
                                List.of(List.of(
                                         new InlineKeyboardButton(
                                                 message,
                                                  Optional.empty(),
                                                 Optional.empty(),
                                                 Optional.of(message),
                                                 Optional.empty(),
                                                 Optional.empty(),
                                                 Optional.empty(),
                                                 Optional.empty()
                                         )
                                ))
                        )
                )
        );

        return sendMessage(textMessage);
    }

    private CompletableFuture<ResponseWrapper<Message>> sendMessage(SendMessageBody body) {
        return client.postRequest(new SendMessage(body));
    }
}
