package dev.tobee.telegram.model.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.OptionalLong;

public record BotCommandScopeChatMember(
        @JsonProperty("chat_id") OptionalLong chatId,
        @JsonProperty("user_id") OptionalLong userId
) implements BotCommandScope {
    private static final String type = "chat_member";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public OptionalLong getChatId() {
        return chatId;
    }

    @Override
    public OptionalLong getUserId() {
        return userId;
    }
}
