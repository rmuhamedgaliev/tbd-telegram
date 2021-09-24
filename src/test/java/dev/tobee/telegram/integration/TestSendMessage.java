package dev.tobee.telegram.integration;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.ChatAction;
import dev.tobee.telegram.model.DiceEmoji;
import dev.tobee.telegram.model.InputFile;
import dev.tobee.telegram.model.KeyboardButton;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.MessageEntityType;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ReplyKeyboardMarkup;
import dev.tobee.telegram.request.GetMe;
import dev.tobee.telegram.request.SendChatAction;
import dev.tobee.telegram.request.SendChatActionBody;
import dev.tobee.telegram.request.SendDice;
import dev.tobee.telegram.request.SendLocation;
import dev.tobee.telegram.request.SendMessage;
import dev.tobee.telegram.request.SendPhoto;
import dev.tobee.telegram.request.body.SendDiceBody;
import dev.tobee.telegram.request.body.SendLocationBody;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.body.SendPhotoBody;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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

    @Test
    public void sendPhotoTest() throws IOException {

        Path path = new File("data/1x1.png").toPath();

        var sendMessage = new SendPhoto(
                new SendPhotoBody(
                        chatId,
                        new InputFile(
                                path.getFileName().toString(),
                                Files.probeContentType(path),
                                new FileInputStream(path.toFile()).readAllBytes()
                        ),
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

    @Test
    public void sendLocationTest() {
        var request = new SendLocation(new SendLocationBody(
                chatId,
                56.636525f,
                47.890116f,
                100f,
                OptionalInt.of(86400),
                OptionalInt.of(360),
                OptionalInt.of(500),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()

        ));

        var response = client.postRequest(request).join();

        System.out.println(response);
    }

    @Test
    public void sendDiceTest() {
        var request = new SendDice(new SendDiceBody(
                chatId,
                Optional.of(DiceEmoji.DIRECT_HIT),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        var response = client.postRequest(request).join();

        System.out.println(response);
    }

    @Test
    public void sendChatActionTest() {
        var request = new SendChatAction(new SendChatActionBody(
                chatId,
                ChatAction.TYPING
        ));

        var response = client.postRequest(request).join();

        System.out.println(response);
    }

    @Test
    public void getMeTest() {
        var request = new GetMe();

        var response = client.getRequest(request).join();

        System.out.println(response);
    }
}
