package dev.tobee.telegram.request.body;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PinChatMessageBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") long messageId,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification
) {
}
