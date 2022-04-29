package dev.tobee.telegram.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VideoChatScheduled(
        @JsonProperty("start_date") int startDate
) {
}
