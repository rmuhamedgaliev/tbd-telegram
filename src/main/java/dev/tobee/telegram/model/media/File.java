package dev.tobee.telegram.model.media;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record File(
        @JsonProperty("file_id") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("file_size") OptionalLong fileSize,
        @JsonProperty("file_path") Optional<String> filePath
) {
}
