package dev.tobee.telegram.request.message;

import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.UnpinChatMessageBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnpinChatMessageTest {

    @Test
    void checkValidRequest() {
        UnpinChatMessage unpinChatMessage = new UnpinChatMessage(
                new UnpinChatMessageBody(159L, OptionalLong.of(159L))
        );

        Assertions.assertEquals(unpinChatMessage.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("unpinChatMessage", unpinChatMessage.getMethod());
        Assertions.assertTrue(unpinChatMessage.getBody().isPresent());
    }
}
