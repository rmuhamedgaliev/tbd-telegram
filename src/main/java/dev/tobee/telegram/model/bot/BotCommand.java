package dev.tobee.telegram.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotCommand(
        @JsonProperty("command") String command,
        @JsonProperty("description") String description
) {
}
