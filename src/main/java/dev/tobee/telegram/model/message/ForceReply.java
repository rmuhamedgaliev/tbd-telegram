package dev.tobee.telegram.model.message;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ForceReply(
        @JsonProperty("force_reply") Boolean forceReply,
        @JsonProperty("input_field_placeholder") Optional<String> inputFieldPlaceholder,
        @JsonProperty("selective") Optional<Boolean> selective
) implements ReplyMarkup {
}
