package dev.tobee.telegram.requests;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.UUID;

import dev.tobee.telegram.TdLibInitHandler;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.message.SendMessage;
import it.tdlight.jni.TdApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestSendMessage extends BaseRequestsTest {

    @Test
    public void testSendTextMessage() {
        String message = UUID.randomUUID().toString();
        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);
            TdLibInitHandler.TD_LIB_INIT.getClient().sendClose();
        });
        var sendMessage = new SendMessage(
                new SendMessageBody(
                        DESTINATION_USER,
                        message,
                        Optional.empty(),
                        Collections.emptyList(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        OptionalLong.empty(),
                        Optional.empty(),
                        Optional.empty()
                ));
        BOT.postRequest(sendMessage).join();
    }

}
