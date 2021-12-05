package dev.tobee.telegram.request.body;

import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetUserProfilePhotosBody(
        @JsonProperty("user_id") long userId,
        @JsonProperty("offset") OptionalInt offset,
        @JsonProperty("limit") OptionalInt limit
) {
}
