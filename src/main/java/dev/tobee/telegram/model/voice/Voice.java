package dev.tobee.telegram.model.voice;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalInt;

public record Voice(
        @JsonProperty("fileId") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("duration") int duration,
        @JsonProperty("mime_type") Optional<String> mimeType,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
