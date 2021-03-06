package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalInt;

public record Audio(
        @JsonProperty("fileId") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("duration") int duration,
        @JsonProperty("performer") Optional<String> performer,
        @JsonProperty("title") Optional<String> title,
        @JsonProperty("file_name") Optional<String> fileName,
        @JsonProperty("mime_type") Optional<String> mimeType,
        @JsonProperty("file_size") OptionalInt fileSize,
        @JsonProperty("thumb") Optional<PhotoSize> thumb
) {
}
