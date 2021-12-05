package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ChatAction;

public record SendChatActionBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("action") ChatAction action
) {
}
