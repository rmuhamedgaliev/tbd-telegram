package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VoiceChatEnded(
        @JsonProperty("duration") int duration
) {
}
