package dev.tobee.telegram.model.media;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Animation(
        @JsonProperty("file_id") String file_id,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("width") int width,
        @JsonProperty("height") int height,
        @JsonProperty("duration") int duration,
        @JsonProperty("thumb") Optional<PhotoSize> thumb,
        @JsonProperty("file_name") Optional<String> fileName,
        @JsonProperty("mime_type") Optional<String> mimeType,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
