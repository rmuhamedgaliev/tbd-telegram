package dev.tobee.telegram.model.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

import java.util.List;

public record PollAnswer(
        @JsonProperty("poll_id") String pollId,
        @JsonProperty("user") User user,
        @JsonProperty("option_ids") List<Integer> optionIds
) {
}
