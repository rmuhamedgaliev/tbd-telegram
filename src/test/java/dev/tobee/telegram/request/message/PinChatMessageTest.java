package dev.tobee.telegram.request.message;

import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.PinChatMessageBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PinChatMessageTest {

    @Test
    void checkValidRequest() {
        PinChatMessage pinChatMessage = new PinChatMessage(
                new PinChatMessageBody(159L, 159L, Optional.empty())
        );

        Assertions.assertEquals(pinChatMessage.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("pinChatMessage", pinChatMessage.getMethod());
        Assertions.assertTrue(pinChatMessage.getBody().isPresent());
    }
}
