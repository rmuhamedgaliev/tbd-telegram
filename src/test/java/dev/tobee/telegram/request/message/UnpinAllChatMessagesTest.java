package dev.tobee.telegram.request.message;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.UnpinAllChatMessagesBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnpinAllChatMessagesTest {

    @Test
    void checkValidRequest() {
        UnpinAllChatMessages unpinAllChatMessages = new UnpinAllChatMessages(
                new UnpinAllChatMessagesBody(159L)
        );

        Assertions.assertEquals(unpinAllChatMessages.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("unpinAllChatMessages", unpinAllChatMessages.getMethod());
        Assertions.assertTrue(unpinAllChatMessages.getBody().isPresent());
    }
}
