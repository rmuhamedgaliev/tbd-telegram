package dev.tobee.telegram.request.sendobject;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatAction;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendChatActionBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendChatActionTest {

    @Test
    void checkValidRequest() {
        SendChatAction sendChatAction = new SendChatAction(
                new SendChatActionBody(159L, ChatAction.TYPING)
        );

        Assertions.assertEquals(sendChatAction.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendChatAction", sendChatAction.getMethod());
        Assertions.assertTrue(sendChatAction.getBody().isPresent());
    }
}
