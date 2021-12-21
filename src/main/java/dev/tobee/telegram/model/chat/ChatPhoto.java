package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatPhoto(
        @JsonProperty("small_file_id") String smallFileId,
        @JsonProperty("small_file_unique_id") String smallFileUniqueId,
        @JsonProperty("big_file_id") String bigFileId,
        @JsonProperty("big_file_unique_id") String bigFileUniqueId
) {
}
