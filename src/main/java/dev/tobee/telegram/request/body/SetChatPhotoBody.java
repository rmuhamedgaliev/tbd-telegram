package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.InputFile;

public record SetChatPhotoBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("photo") InputFile photo
) {
}
