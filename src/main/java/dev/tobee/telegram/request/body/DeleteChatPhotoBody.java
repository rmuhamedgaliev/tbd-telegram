package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteChatPhotoBody(
        @JsonProperty("chat_id") long chatId
) {
}
