package dev.tobee.telegram.model.bot;

public record BotCommandScopeDefault() implements BotCommandScope {

    private static final String type = "default";

    @Override
    public String getType() {
        return type;
    }
}
