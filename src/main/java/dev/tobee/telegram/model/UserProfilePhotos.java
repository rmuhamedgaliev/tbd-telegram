package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public record UserProfilePhotos(
        @JsonProperty("total_count") OptionalInt totalCount,
        @JsonProperty("photos") Optional<List<List<PhotoSize>>> photos
) {
}
