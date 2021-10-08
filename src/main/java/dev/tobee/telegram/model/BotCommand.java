package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotCommand(
        @JsonProperty("command") String command,
        @JsonProperty("description") String description
) {
}
