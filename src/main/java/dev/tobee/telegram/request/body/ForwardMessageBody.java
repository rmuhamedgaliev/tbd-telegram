package dev.tobee.telegram.request.body;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ForwardMessageBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("from_chat_id") long fromChatId,
        @JsonProperty("protect_content") Optional<Boolean> protectContent,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("message_id") OptionalLong messageId
) {
}
