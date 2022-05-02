package dev.tobee.telegram.demo;

import java.util.Collections;

import dev.tobee.telegram.LongPollingTelegramBot;
import dev.tobee.telegram.client.TbdAsyncClient;

public class DemoBot {
    private static final String HOST = "http://localhost:8081";

    public static void main(String[] args) {
        var token = System.getenv().get("TBD_TELEGRAM_TOKEN");
        var tbdClient = new TbdAsyncClient(false, HOST, token);
        var bot = new LongPollingTelegramBot(tbdClient, Collections.singletonList(new EchoSubscriber(tbdClient)));
        bot.subscribeToUpdate();
    }
}
