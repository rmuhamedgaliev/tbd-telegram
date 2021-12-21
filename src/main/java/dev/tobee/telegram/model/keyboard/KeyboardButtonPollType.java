package dev.tobee.telegram.model.keyboard;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KeyboardButtonPollType(
        @JsonProperty("type") Optional<String> type
) {
}
