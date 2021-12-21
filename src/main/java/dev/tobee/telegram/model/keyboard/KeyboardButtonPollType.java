package dev.tobee.telegram.model.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record KeyboardButtonPollType(
        @JsonProperty("type") Optional<String> type
) {
}
