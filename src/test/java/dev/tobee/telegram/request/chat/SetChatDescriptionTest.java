package dev.tobee.telegram.request.chat;

import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetChatDescriptionBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetChatDescriptionTest {

    @Test
    void checkValidRequest() {
        SetChatDescription setChatDescription = new SetChatDescription(
                new SetChatDescriptionBody(159L, Optional.empty())
        );

        Assertions.assertEquals(setChatDescription.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("setChatDescription", setChatDescription.getMethod());
        Assertions.assertTrue(setChatDescription.getBody().isPresent());
    }
}
