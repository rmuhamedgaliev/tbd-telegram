package dev.tobee.telegram.integration.tests;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalLong;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.integration.TdLibInitHandler;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.message.SendMessage;
import it.tdlight.jni.TdApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TdLibInitHandler.class})
public class TestSendMessageFromBotToBot {
    private static final String HOST = "https://api.telegram.org";
    private static final TbdAsyncClient bot1 = new TbdAsyncClient(false, HOST, System.getenv("TBD_TELEGRAM_TOKEN"));

    @Test
    public void checkSendMessageFromBot2Bot() {

        String message = "Hello Bot2";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);

            TdLibInitHandler.TD_LIB_INIT.getClient().sendClose();
        });

        var sendMessage = new SendMessage(
                new SendMessageBody(
                        5338423141L,
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

        bot1.postRequest(sendMessage).join().result();
    }

    @Test
    public void checkSendMessageFromBot2Bot1() {

        String message = "Hello Bot2";

        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            Assertions.assertNotNull(update.message.content);
            Assertions.assertEquals(message, ((TdApi.MessageText) update.message.content).text.text);

            TdLibInitHandler.TD_LIB_INIT.getClient().sendClose();
        });

        var sendMessage = new SendMessage(
                new SendMessageBody(
                        5338423141L,
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

        bot1.postRequest(sendMessage).join().result();
    }

}
