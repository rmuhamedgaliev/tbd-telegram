package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.bot.BotCommand;
import dev.tobee.telegram.model.bot.BotCommandScope;

import java.util.List;
import java.util.Optional;

public record SetMyCommandsBody(
        @JsonProperty("commands") List<BotCommand> commands,
        @JsonProperty("scope") Optional<BotCommandScope> scope,
        @JsonProperty("language_code") Optional<String> languageCode
) {
}
