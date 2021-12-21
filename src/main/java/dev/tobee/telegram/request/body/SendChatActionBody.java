package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.chat.ChatAction;

public record SendChatActionBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("action") ChatAction action
) {
}
