package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.OptionalInt;

public record VideoNote(
        @JsonProperty("file_id") String fileId,
        @JsonProperty("file_unique_id") String fileUniqueId,
        @JsonProperty("length") int length,
        @JsonProperty("duration") int duration,
        @JsonProperty("thumb") PhotoSize thumb,
        @JsonProperty("file_size") OptionalInt fileSize
) {
}
