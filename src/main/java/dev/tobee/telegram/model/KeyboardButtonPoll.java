package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KeyboardButtonPoll(
        @JsonProperty("text") String text
) {
}
