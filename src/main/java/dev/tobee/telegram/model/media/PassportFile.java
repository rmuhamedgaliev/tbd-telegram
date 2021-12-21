package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PassportFile(
        @JsonProperty("file_id") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("file_size") int fileSize,
        @JsonProperty("file_date") int fileDate
) {
}
