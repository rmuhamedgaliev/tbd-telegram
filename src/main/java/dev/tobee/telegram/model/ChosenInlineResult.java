package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record ChosenInlineResult(
        @JsonProperty("result_id") String resultId,
        @JsonProperty("from") User from,
        @JsonProperty("location") Optional<Location> location,
        @JsonProperty("inline_message_id") Optional<String> inlineMessageId,
        @JsonProperty("query") Optional<String> query
) {
}
