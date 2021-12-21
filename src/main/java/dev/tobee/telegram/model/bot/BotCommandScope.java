package dev.tobee.telegram.model.bot;

import java.util.OptionalLong;

public interface BotCommandScope {

    String getType();

    default OptionalLong getChatId() {
        return OptionalLong.empty();
    }

    default OptionalLong getUserId() {
        return OptionalLong.empty();
    }
}
