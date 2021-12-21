package dev.tobee.telegram.request.message;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.ForwardMessageBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ForwardMessageTest {

    @Test
    void checkValidRequest() {
        ForwardMessage forwardMessage = new ForwardMessage(
                new ForwardMessageBody(159L, 159L, Optional.empty(), OptionalLong.empty())
        );

        Assertions.assertEquals(forwardMessage.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {}).getType().getTypeName());
        Assertions.assertEquals("forwardMessage", forwardMessage.getMethod());
        Assertions.assertTrue(forwardMessage.getBody().isPresent());
    }
}
