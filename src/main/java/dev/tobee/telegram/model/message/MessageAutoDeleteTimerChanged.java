package dev.tobee.telegram.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageAutoDeleteTimerChanged(
        @JsonProperty("message_auto_delete_time") int messageAutoDeleteTime
) {
}
