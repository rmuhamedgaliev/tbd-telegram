package dev.tobee.telegram.integration;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.KeyboardButton;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.MessageEntityType;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ReplyKeyboardMarkup;
import dev.tobee.telegram.request.SendMessage;
import dev.tobee.telegram.request.body.SendMessageBody;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.util.List;
import java.util.Optional;

@EnabledIfEnvironmentVariable(named = "integration", matches = "true")
public class TestSendMessage {

    private final String host = "https://api.telegram.org";

    private final String token = System.getenv("TBD_TELEGRAM_TOKEN");

    private final int chatId = 353734572;

    private final TbdAsyncClient client = new TbdAsyncClient(true, host, token);

    @Test
    public void sendMessageTest() {
        var sendMessage = new SendMessage(
                new SendMessageBody(
                        chatId,
                        "Slight scenic powder tablet public cult short, anniversary.",
                        Optional.of(ParseMode.HTML),
                        List.of(new MessageEntity(
                                MessageEntityType.BOLD,
                                100,
                                100,
                                Optional.of("https://deathqj00yf.mr"),
                                Optional.empty(),
                                Optional.empty()
                        )),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.of(new ReplyKeyboardMarkup(
                                List.of(List.of(new KeyboardButton("Hello.", Optional.empty(),
                                        Optional.of(Boolean.TRUE), Optional.empty()))),
                                Optional.of(Boolean.TRUE),
                                Optional.of(Boolean.TRUE),
                                Optional.of("Hello"),
                                Optional.of(Boolean.TRUE)
                        ))
                ));

        var response = client.postRequest(sendMessage).join();

        System.out.println(response);
    }
}
