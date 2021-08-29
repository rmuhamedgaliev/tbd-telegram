package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalInt;

public record Sticker(
        @JsonProperty("file_id") String file_id,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("width") int width,
        @JsonProperty("height") int height,
        @JsonProperty("is_animated") Boolean isAnimated,
        @JsonProperty("thumb") Optional<PhotoSize> thumb,
        @JsonProperty("emoji") Optional<String> emoji,
        @JsonProperty("set_name") Optional<String> fileName,
        @JsonProperty("mask_position") Optional<MaskPosition> mimeType,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
