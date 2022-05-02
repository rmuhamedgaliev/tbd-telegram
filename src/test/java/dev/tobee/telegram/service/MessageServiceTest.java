package dev.tobee.telegram.service;

import dev.tobee.telegram.BaseRequestsTest;
import dev.tobee.telegram.TdLibInitHandler;
import dev.tobee.telegram.model.message.ParseMode;
import dev.tobee.telegram.request.body.SendMessageBody;
import it.tdlight.jni.TdApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * @author <a href="mailto:rinat.muhamedgaliev@gmail.com">Rinat Muhamedgaliev</a>
 */
@DisplayName("Test send different messages")
class MessageServiceTest extends BaseRequestsTest {

    private final MessageService messageService;

    MessageServiceTest() {
        this.messageService = new MessageService(CLIENT);
    }

    @Test
    @DisplayName("Test send plain text message")
    public void testSendPlainTextMessage() {
        String message = "Offshore organization verzeichnis greek theft forestry logitech.";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);
        });

        var response = messageService.sendTextMessage(DESTINATION_USER, message).join();

        Assertions.assertTrue(response.ok());
        Assertions.assertTrue(response.result().isPresent());
        Assertions.assertTrue(response.result().get().text().isPresent());
        Assertions.assertEquals(message, response.result().get().text().get());
    }

    @Test
    public void testSendMarkdownFormattedMessage() {
        String message = "`Offshore` *organization* _verzeichnis_ greek theft forestry logitech\\.";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);
        });

        var body = new SendMessageBody(
                DESTINATION_USER,
                message,
                Optional.of(ParseMode.MARKDOWN_V2),
                Collections.emptyList(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                OptionalLong.empty(),
                Optional.empty(),
                Optional.empty()
        );

        var response = messageService.sendMessage(body).join();

        Assertions.assertTrue(response.ok());
        Assertions.assertTrue(response.result().isPresent());
        Assertions.assertTrue(response.result().get().text().isPresent());

        var expected = "Offshore organization verzeichnis greek theft forestry logitech.";
        Assertions.assertEquals(expected, response.result().get().text().get());
    }

    @Test
    public void testSendMarkdownV2FormattedMessage() {
        String message = "~Offshore~ **organization** __verzeichnis__ ||greek|| theft forestry logitech\\.";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);
        });

        var body = new SendMessageBody(
                DESTINATION_USER,
                message,
                Optional.of(ParseMode.MARKDOWN_V2),
                Collections.emptyList(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                OptionalLong.empty(),
                Optional.empty(),
                Optional.empty()
        );

        var response = messageService.sendMessage(body).join();

        Assertions.assertTrue(response.ok());
        Assertions.assertTrue(response.result().isPresent());
        Assertions.assertTrue(response.result().get().text().isPresent());

        var expected = "Offshore organization verzeichnis greek theft forestry logitech.";
        Assertions.assertEquals(expected, response.result().get().text().get());
    }

}
