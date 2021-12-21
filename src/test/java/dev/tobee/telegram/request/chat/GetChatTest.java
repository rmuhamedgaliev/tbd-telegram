package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.Chat;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.GetChatBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetChatTest {

    @Test
    void checkValidRequest() {
        GetChat getChat = new GetChat(
                new GetChatBody(614L)
        );

        Assertions.assertEquals(getChat.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Chat>>() {}).getType().getTypeName());
        Assertions.assertEquals("getChat", getChat.getMethod());
        Assertions.assertTrue(getChat.getBody().isPresent());
    }
}
