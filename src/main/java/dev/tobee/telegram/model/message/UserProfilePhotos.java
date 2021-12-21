package dev.tobee.telegram.model.message;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.PhotoSize;

public record UserProfilePhotos(
        @JsonProperty("total_count") OptionalInt totalCount,
        @JsonProperty("photos") Optional<List<List<PhotoSize>>> photos
) {
}
