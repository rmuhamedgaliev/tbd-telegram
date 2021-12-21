package dev.tobee.telegram.request.message;

import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.DeleteMessageBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteMessageTest {

    @Test
    void checkValidRequest() {
        DeleteMessage deleteMessage = new DeleteMessage(
                new DeleteMessageBody(159L, OptionalLong.of(159L))
        );

        Assertions.assertEquals(deleteMessage.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("deleteMessage", deleteMessage.getMethod());
        Assertions.assertTrue(deleteMessage.getBody().isPresent());
    }

}
