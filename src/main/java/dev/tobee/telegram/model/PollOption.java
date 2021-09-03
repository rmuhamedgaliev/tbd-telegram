package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PollOption(
        @JsonProperty("text") String text,
        @JsonProperty("voter_count") int voterCount
) {
}
