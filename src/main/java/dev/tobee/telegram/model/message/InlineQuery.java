package dev.tobee.telegram.model.message;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.chat.ChatType;
import dev.tobee.telegram.model.media.Location;

public record InlineQuery(
        @JsonProperty("id") String id,
        @JsonProperty("from") User from,
        @JsonProperty("query") String query,
        @JsonProperty("offset") String offset,
        @JsonProperty("chat_type") Optional<ChatType> chatType,
        @JsonProperty("location") Optional<Location> location
) {
}
