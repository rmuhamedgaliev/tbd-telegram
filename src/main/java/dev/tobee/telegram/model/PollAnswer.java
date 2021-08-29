package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PollAnswer(
        @JsonProperty("poll_id") String pollId,
        @JsonProperty("user") User user,
        @JsonProperty("option_ids")List<Integer> optionIds
        ) {
}
