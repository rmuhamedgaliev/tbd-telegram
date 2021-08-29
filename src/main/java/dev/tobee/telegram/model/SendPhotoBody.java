package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.nio.file.Path;

public record SendPhotoBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("photo") Path photo
) {
}
