package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageId(
        @JsonProperty("message_id") int messageId
) {
}
