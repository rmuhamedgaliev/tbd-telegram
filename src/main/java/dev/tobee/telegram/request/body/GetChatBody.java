package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetChatBody(
        @JsonProperty("chat_id") Long chatId
) {
}
