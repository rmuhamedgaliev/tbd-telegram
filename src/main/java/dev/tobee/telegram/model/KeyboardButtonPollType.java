package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record KeyboardButtonPollType(
        @JsonProperty("type") Optional<String> type
) {
}
