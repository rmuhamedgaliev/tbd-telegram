package dev.tobee.telegram.request.message;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendMessageBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendMessageTest {

    @Test
    void checkValidRequest() {
        SendMessage sendMessage = new SendMessage(
                new SendMessageBody(159L, "eval", Optional.empty(), List.of(), Optional.empty(), Optional.empty(),
                        Optional.empty(), OptionalLong.empty(), Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(sendMessage.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendMessage", sendMessage.getMethod());
        Assertions.assertTrue(sendMessage.getBody().isPresent());
    }
}
