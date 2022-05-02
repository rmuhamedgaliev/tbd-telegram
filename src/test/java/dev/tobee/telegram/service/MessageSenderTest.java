package dev.tobee.telegram.service;

import dev.tobee.telegram.BaseRequestsTest;
import dev.tobee.telegram.TdLibInitHandler;
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
@DisplayName("Test send different messages with raw body")
public class MessageSenderTest extends BaseRequestsTest {

    private final MessageService messageService;

    public MessageSenderTest() {
        this.messageService = new MessageService(CLIENT);
    }

    @Test
    public void sendProtectedMessage() {
        String message = "Offshore organization verzeichnis greek theft forestry logitech.";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertFalse(update.message.canBeForwarded);
            Assertions.assertFalse(update.message.canBeSaved);
        });

        var body = new SendMessageBody(
                DESTINATION_USER,
                message,
                Optional.empty(),
                Collections.emptyList(),
                Optional.empty(),
                Optional.empty(),
                Optional.of(Boolean.TRUE),
                OptionalLong.empty(),
                Optional.empty(),
                Optional.empty()
        );

        var response = messageService.sendMessage(body).join();

        Assertions.assertTrue(response.ok());
        Assertions.assertTrue(response.result().isPresent());
        Assertions.assertTrue(response.result().get().text().isPresent());
        Assertions.assertEquals(message, response.result().get().text().get());
    }

    @Test
    public void sendUrlWithPreviewMessage() {
        String message = "https://ya.ru";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).webPage.url);
        });

        var body = new SendMessageBody(
                DESTINATION_USER,
                message,
                Optional.empty(),
                Collections.emptyList(),
                Optional.of(Boolean.FALSE),
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
    }

    @Test
    public void sendUrlWithOutPreviewMessage() {
        String message = "https://ya.ru";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNull(((TdApi.MessageText) update.message.content).webPage);
        });

        var body = new SendMessageBody(
                DESTINATION_USER,
                message,
                Optional.empty(),
                Collections.emptyList(),
                Optional.of(Boolean.TRUE),
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
    }

}
