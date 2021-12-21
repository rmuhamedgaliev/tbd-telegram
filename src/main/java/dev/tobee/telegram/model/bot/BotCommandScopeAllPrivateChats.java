package dev.tobee.telegram.model.bot;

public record BotCommandScopeAllPrivateChats() implements BotCommandScope {

    private static final String type = "all_private_chats";

    @Override
    public String getType() {
        return type;
    }
}
