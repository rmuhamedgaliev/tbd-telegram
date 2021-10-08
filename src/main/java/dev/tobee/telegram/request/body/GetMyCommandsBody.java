package dev.tobee.telegram.request.body;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.BotCommandScope;

public record GetMyCommandsBody(
        @JsonProperty("scope") Optional<BotCommandScope> scope,
        @JsonProperty("language_code") Optional<String> languageCode
        ) {
}
