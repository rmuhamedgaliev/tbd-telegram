package dev.tobee.telegram.model;

public record BotCommandScopeAllChatAdministrators() implements BotCommandScope {
    private static final String type = "all_chat_administrators";

    @Override
    public String getType() {
        return type;
    }
}
