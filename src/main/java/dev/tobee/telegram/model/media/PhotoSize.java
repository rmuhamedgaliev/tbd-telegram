package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.OptionalInt;

public record PhotoSize(
        @JsonProperty("fileId") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("width") int width,
        @JsonProperty("height") int height,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
