package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdAsyncClient;

public interface TelegramBot {

    void subscribeToUpdate();

    TbdAsyncClient getClient();
}
