package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteChatStickerSetBody(
        @JsonProperty("chat_id") long chatId
) {
}
