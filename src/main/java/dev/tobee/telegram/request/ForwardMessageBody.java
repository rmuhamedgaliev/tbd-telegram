package dev.tobee.telegram.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record ForwardMessageBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("from_chat_id") int fromChatId,
        @JsonProperty("disable_notification")Optional<Boolean> disableNotification,
        @JsonProperty("message_id") int messageId
) {
}
