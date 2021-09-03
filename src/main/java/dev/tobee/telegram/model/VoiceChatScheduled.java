package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VoiceChatScheduled(
        @JsonProperty("start_date") int startDate
) {
}
