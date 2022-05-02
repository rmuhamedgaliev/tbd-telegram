package dev.tobee.telegram.service;

import dev.tobee.telegram.client.TelegramApiClient;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ParseMode;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.message.SendMessage;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.CompletableFuture;

/**
 * Service class for send message
 *
 * @author <a href="mailto:rinat.muhamedgaliev@gmail.com">Rinat Muhamedgaliev</a>
 */
public record MessageService(TelegramApiClient client) {

    /**
     * Send simple text message to chat
     *
     * @param chatId  id od telegram chat or user
     * @param message text value of message
     * @return {@link Message} object of sent message
     */
    public CompletableFuture<ResponseWrapper<Message>> sendTextMessage(long chatId, String message) {
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
                Optional.empty()
        );

        return sendMessage(textMessage);
    }

    public CompletableFuture<ResponseWrapper<Message>> sendMarkdownTextMessage(long chatId, String message) {
        var textMessage = new SendMessageBody(
                chatId,
                message,
                Optional.of(ParseMode.MARKDOWN),
                Collections.emptyList(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                OptionalLong.empty(),
                Optional.empty(),
                Optional.empty()
        );

        return sendMessage(textMessage);
    }

    public CompletableFuture<ResponseWrapper<Message>> sendMarkdownV2TextMessage(long chatId, String message) {
        var textMessage = new SendMessageBody(
                chatId,
                message,
                Optional.of(ParseMode.MARKDOWN_V2),
                Collections.emptyList(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                OptionalLong.empty(),
                Optional.empty(),
                Optional.empty()
        );

        return sendMessage(textMessage);
    }

    public CompletableFuture<ResponseWrapper<Message>> sendHTMLTextMessage(long chatId, String message) {
        var textMessage = new SendMessageBody(
                chatId,
                message,
                Optional.of(ParseMode.HTML),
                Collections.emptyList(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                OptionalLong.empty(),
                Optional.empty(),
                Optional.empty()
        );

        return sendMessage(textMessage);
    }

    /**
     * Send message with raw {@link SendMessageBody}
     *
     * @param body configurable body object {@link SendMessageBody}
     * @return {@link Message} object of sent message
     */
    public CompletableFuture<ResponseWrapper<Message>> sendMessage(SendMessageBody body) {
        return client.postRequest(new SendMessage(body));
    }
}
