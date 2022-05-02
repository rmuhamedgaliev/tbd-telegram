package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalInt;

public record Sticker(
        @JsonProperty("fileId") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("width") int width,
        @JsonProperty("height") int height,
        @JsonProperty("is_animated") Boolean isAnimated,
        @JsonProperty("is_video") Boolean isVideo,
        @JsonProperty("thumb") Optional<PhotoSize> thumb,
        @JsonProperty("emoji") Optional<String> emoji,
        @JsonProperty("set_name") Optional<String> fileName,
        @JsonProperty("mask_position") Optional<MaskPosition> mimeType,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
