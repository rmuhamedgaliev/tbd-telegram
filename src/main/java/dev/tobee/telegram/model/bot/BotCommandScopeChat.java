package dev.tobee.telegram.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.OptionalLong;

public record BotCommandScopeChat(@JsonProperty("chat_id") OptionalLong chatId) implements BotCommandScope {
    private static final String type = "chat";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public OptionalLong getChatId() {
        return chatId;
    }
}
