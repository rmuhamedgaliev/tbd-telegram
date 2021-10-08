package dev.tobee.telegram.model;

import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

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
