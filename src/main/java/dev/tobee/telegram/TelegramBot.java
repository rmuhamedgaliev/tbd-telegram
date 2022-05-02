package dev.tobee.telegram;

import dev.tobee.telegram.client.TelegramApiClient;

public interface TelegramBot {

    void subscribeToUpdate();

    TelegramApiClient getClient();
}
