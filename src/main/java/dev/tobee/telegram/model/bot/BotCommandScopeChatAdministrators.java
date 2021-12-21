package dev.tobee.telegram.model.bot;

import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BotCommandScopeChatAdministrators(
        @JsonProperty("chat_id") OptionalLong chatId) implements BotCommandScope {
    private static final String type = "chat_administrators";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public OptionalLong getChatId() {
        return chatId;
    }
}