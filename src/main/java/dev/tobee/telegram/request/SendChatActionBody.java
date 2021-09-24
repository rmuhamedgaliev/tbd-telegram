package dev.tobee.telegram.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ChatAction;

public record SendChatActionBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("action") ChatAction action
) {
}
