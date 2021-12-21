package dev.tobee.telegram.model.voice;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Voice(
        @JsonProperty("file_id") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("duration") int duration,
        @JsonProperty("mime_type") Optional<String> mimeType,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
