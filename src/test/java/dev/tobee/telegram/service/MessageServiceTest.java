package dev.tobee.telegram.service;

import dev.tobee.telegram.BaseRequestsTest;
import dev.tobee.telegram.TdLibInitHandler;
import it.tdlight.jni.TdApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:rinat.muhamedgaliev@gmail.com">Rinat Muhamedgaliev</a>
 */
@DisplayName("Test send different messages")
class MessageServiceTest extends BaseRequestsTest {

    private final MessageService messageService;

    public MessageServiceTest() {
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
    @DisplayName("Test send markdown formatted message")
    public void testSendMarkdownFormattedMessage() {
        String message = "`Offshore` *organization* _verzeichnis_ greek theft forestry logitech.";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);
        });

        var response = messageService.sendMarkdownTextMessage(DESTINATION_USER, message).join();

        Assertions.assertTrue(response.ok());
        Assertions.assertTrue(response.result().isPresent());
        Assertions.assertTrue(response.result().get().text().isPresent());

        var expected = "Offshore organization verzeichnis greek theft forestry logitech.";
        Assertions.assertEquals(expected, response.result().get().text().get());
    }

    @Test
    @DisplayName("Test send markdown_v2 formatted message")
    public void testSendMarkdownV2FormattedMessage() {
        String message = "~Offshore~ **organization** __verzeichnis__ ||greek|| theft forestry logitech\\.";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);
        });

        var response = messageService.sendMarkdownV2TextMessage(DESTINATION_USER, message).join();

        Assertions.assertTrue(response.ok());
        Assertions.assertTrue(response.result().isPresent());
        Assertions.assertTrue(response.result().get().text().isPresent());

        var expected = "Offshore organization verzeichnis greek theft forestry logitech.";
        Assertions.assertEquals(expected, response.result().get().text().get());
    }

    @Test
    @DisplayName("Test send html formatted message")
    public void testSendHTMLFormattedMessage() {
        String message = "<s>Offshore</s> <b>organization</b> <i>verzeichnis</i> greek theft forestry logitech.";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);
        });

        var response = messageService.sendHTMLTextMessage(DESTINATION_USER, message).join();

        Assertions.assertTrue(response.ok());
        Assertions.assertTrue(response.result().isPresent());
        Assertions.assertTrue(response.result().get().text().isPresent());

        var expected = "Offshore organization verzeichnis greek theft forestry logitech.";
        Assertions.assertEquals(expected, response.result().get().text().get());
    }

}
