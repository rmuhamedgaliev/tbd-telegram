package dev.tobee.telegram.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.bot.BotCommand;
import dev.tobee.telegram.model.bot.BotCommandScopeDefault;
import dev.tobee.telegram.model.chat.ChatAction;
import dev.tobee.telegram.model.media.DiceEmoji;
import dev.tobee.telegram.model.media.InputFile;
import dev.tobee.telegram.model.keyboard.KeyboardButton;
import dev.tobee.telegram.model.message.MessageEntity;
import dev.tobee.telegram.model.message.MessageEntityType;
import dev.tobee.telegram.model.message.ParseMode;
import dev.tobee.telegram.model.keyboard.ReplyKeyboardMarkup;
import dev.tobee.telegram.request.user.GetMe;
import dev.tobee.telegram.request.sendobject.SendChatAction;
import dev.tobee.telegram.request.body.SendChatActionBody;
import dev.tobee.telegram.request.sendobject.SendDice;
import dev.tobee.telegram.request.sendobject.SendLocation;
import dev.tobee.telegram.request.message.SendMessage;
import dev.tobee.telegram.request.sendobject.SendPhoto;
import dev.tobee.telegram.request.comands.SetMyCommands;
import dev.tobee.telegram.request.body.SendDiceBody;
import dev.tobee.telegram.request.body.SendLocationBody;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.body.SendPhotoBody;
import dev.tobee.telegram.request.body.SetMyCommandsBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

@EnabledIfEnvironmentVariable(named = "integration", matches = "true")
class TestSendMessage {

    private final String host = "https://api.telegram.org";

    private final String token = System.getenv("TBD_TELEGRAM_TOKEN");

    private final int chatId = 353734572;

    private final TbdAsyncClient client = new TbdAsyncClient(true, host, token);

    @Test
    void sendMessageTest() {
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
                        OptionalInt.empty(),
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
        Assertions.assertNotNull(response);
    }

    @Test
    void sendPhotoTest() throws IOException {

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
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()
                        )),
                        Optional.empty(),
                        OptionalInt.empty(),
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
        Assertions.assertNotNull(response);
    }

    @Test
    void sendLocationTest() {
        var request = new SendLocation(new SendLocationBody(
                chatId,
                56.636525f,
                47.890116f,
                100f,
                OptionalInt.of(86400),
                OptionalInt.of(360),
                OptionalInt.of(500),
                Optional.empty(),
                OptionalInt.empty(),
                Optional.empty(),
                Optional.empty()

        ));

        var response = client.postRequest(request).join();
        Assertions.assertNotNull(response);
    }

    @Test
    void sendDiceTest() {
        var request = new SendDice(new SendDiceBody(
                chatId,
                Optional.of(DiceEmoji.DIRECT_HIT),
                Optional.empty(),
                OptionalInt.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        var response = client.postRequest(request).join();
        Assertions.assertNotNull(response);
    }

    @Test
    void sendChatActionTest() {
        var request = new SendChatAction(new SendChatActionBody(
                chatId,
                ChatAction.TYPING
        ));
        var response = client.postRequest(request).join();
        Assertions.assertNotNull(response);
    }

    @Test
    void exportInviteChatActionTest() {
        var request = new SetMyCommands(new SetMyCommandsBody(
                List.of(new BotCommand("login", "Login abc")),
                Optional.of(new BotCommandScopeDefault()),
                Optional.empty()
        ));

        var response = client.postRequest(request).join();
        Assertions.assertNotNull(response);
    }

    @Test
    void getMeTest() {
        var request = new GetMe();
        var response = client.getRequest(request).join();
        Assertions.assertNotNull(response);
    }
}
