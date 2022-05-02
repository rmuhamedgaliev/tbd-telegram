package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record PinChatMessageBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") long messageId,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification
) {
}
