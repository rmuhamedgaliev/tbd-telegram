package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageAutoDeleteTimerChanged(
        @JsonProperty("message_auto_delete_time") int messageAutoDeleteTime
) {
}
