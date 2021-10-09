package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetChatStickerSetBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("sticker_set_name") String stickerSetName
) {
}
