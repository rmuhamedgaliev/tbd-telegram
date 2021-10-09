package dev.tobee.telegram.request.body;

import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UnpinChatMessageBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") OptionalLong messageId
        ) {
}