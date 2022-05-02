package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalLong;

public record File(
        @JsonProperty("fileId") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("file_size") OptionalLong fileSize,
        @JsonProperty("file_path") Optional<String> filePath
) {
}
