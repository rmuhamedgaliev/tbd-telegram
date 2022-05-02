package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.OptionalInt;

public record GetUserProfilePhotosBody(
        @JsonProperty("user_id") long userId,
        @JsonProperty("offset") OptionalInt offset,
        @JsonProperty("limit") OptionalInt limit
) {
}
