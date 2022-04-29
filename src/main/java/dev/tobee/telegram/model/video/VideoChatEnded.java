package dev.tobee.telegram.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VideoChatEnded(
        @JsonProperty("duration") int duration
) {
}
