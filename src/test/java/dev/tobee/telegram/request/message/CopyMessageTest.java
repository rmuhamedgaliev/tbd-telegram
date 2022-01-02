package dev.tobee.telegram.request.message;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.MessageId;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.CopyMessageBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CopyMessageTest {

    @Test
    void checkValidRequest() {
        CopyMessage copyMessage = new CopyMessage(
                new CopyMessageBody(159L, 159L, 159L, Optional.empty(), Optional.empty(), List.of(), Optional.empty()
                        , Optional.empty(), OptionalLong.empty(), Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(copyMessage.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<MessageId>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("copyMessage", copyMessage.getMethod());
        Assertions.assertTrue(copyMessage.getBody().isPresent());
    }
}
