package dev.tobee.telegram.model.message;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.Location;

public record ChosenInlineResult(
        @JsonProperty("result_id") String resultId,
        @JsonProperty("from") User from,
        @JsonProperty("location") Optional<Location> location,
        @JsonProperty("inline_message_id") Optional<String> inlineMessageId,
        @JsonProperty("query") Optional<String> query
) {
}
