package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetChatTitleBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("title") String title
) {
}
