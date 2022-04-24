package dev.tobee.telegram.model.media;

import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VideoNote(
        @JsonProperty("fileId") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("length") int length,
        @JsonProperty("duration") int duration,
        @JsonProperty("thumb") PhotoSize thumb,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
