package dev.tobee.telegram;

public class LonpollingTelegramBotTest {

    public static void main(String[] args) {

        String host = "https://api.telegram.org";

        String token = System.getenv("TBD_TELEGRAM_TOKEN");

        UpdateSubscriber subscriber = new UpdateSubscriber();

        TelegramBot bot = new LongPollingTelegramBot(host, token, subscriber);

        bot.subscribeToUpdate();
    }
}
