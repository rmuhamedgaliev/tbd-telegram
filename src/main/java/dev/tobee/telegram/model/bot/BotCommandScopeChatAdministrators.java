package dev.tobee.telegram.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.OptionalLong;

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
