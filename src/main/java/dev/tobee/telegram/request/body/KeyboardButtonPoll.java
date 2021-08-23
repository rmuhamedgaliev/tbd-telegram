package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KeyboardButtonPoll(
        @JsonProperty("text") String text
) {
}
