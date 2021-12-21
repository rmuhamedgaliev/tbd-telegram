package dev.tobee.telegram.model.bot;

public record BotCommandScopeAllGroupChats() implements BotCommandScope {
    private static final String type = "all_group_chats";

    @Override
    public String getType() {
        return type;
    }
}
