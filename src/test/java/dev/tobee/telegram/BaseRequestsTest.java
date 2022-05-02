package dev.tobee.telegram;

import dev.tobee.telegram.client.TelegramApiClient;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

@ExtendWith({TdLibInitHandler.class})
public class BaseRequestsTest {
    protected static final String HOST = "https://api.telegram.org";
    // If need dump just replace last argument of client to
    // Optional.ofNullable(TelegramApiClient.class.getClassLoader().getResource("responses"))
    protected static final TelegramApiClient CLIENT = new TelegramApiClient(false, HOST, System.getenv(
            "TBD_TELEGRAM_TOKEN"), Optional.empty());
    protected static final long DESTINATION_USER = 5338423141L;
}
