package dev.tobee.telegram.model.message;

import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageId(
        @JsonProperty("message_id") OptionalLong messageId
) {
}
