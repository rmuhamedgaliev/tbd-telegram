package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record ForceReply(
        @JsonProperty("force_reply") Boolean forceReply,
        @JsonProperty("input_field_placeholder") Optional<String> inputFieldPlaceholder,
        @JsonProperty("selective") Optional<Boolean> selective
) implements ReplyMarkup {
}
