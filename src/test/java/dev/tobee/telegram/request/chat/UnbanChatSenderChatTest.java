package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.UnbanChatSenderChatBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnbanChatSenderChatTest {
    @Test
    void checkValidRequest() {
        UnbanChatSenderChat banChatSenderChat = new UnbanChatSenderChat(
                new UnbanChatSenderChatBody(159L, 159L)
        );

        Assertions.assertEquals(banChatSenderChat.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("unbanChatSenderChat", banChatSenderChat.getMethod());
        Assertions.assertTrue(banChatSenderChat.getBody().isPresent());
    }
}
