package dev.tobee.telegram.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record MessageEntity(
        @JsonProperty("type") MessageEntityType type,
        @JsonProperty("offset") Integer offset,
        @JsonProperty("length") Integer length,
        @JsonProperty("url") Optional<String> url,
        @JsonProperty("user") Optional<User> user,
        @JsonProperty("language") Optional<String> language

) {
}
