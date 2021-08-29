package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record InlineQuery(
        @JsonProperty("id") String id,
        @JsonProperty("from") User from,
        @JsonProperty("query") String query,
        @JsonProperty("offset") String offset,
        @JsonProperty("chat_type") Optional<ChatType> chatType,
        @JsonProperty("location") Optional<Location> location
) {
}
