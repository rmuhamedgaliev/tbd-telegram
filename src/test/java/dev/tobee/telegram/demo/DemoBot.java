package dev.tobee.telegram.demo;

import dev.tobee.telegram.LongPollingTelegramBot;
import dev.tobee.telegram.client.TelegramApiClient;

import java.util.Collections;
import java.util.Optional;

public class DemoBot {
    private static final String HOST = "http://localhost:8081";

    public static void main(String[] args) {
        var token = System.getenv().get("TBD_TELEGRAM_TOKEN");
        var tbdClient = new TelegramApiClient(false, HOST, token, Optional.empty());
        var bot = new LongPollingTelegramBot(tbdClient, Collections.singletonList(new EchoSubscriber(tbdClient)));
        bot.subscribeToUpdate();
    }
}
