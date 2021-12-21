package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.BanChatSenderChatBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BanChatSenderChatTest {
    @Test
    void checkValidRequest() {
        BanChatSenderChat banChatSenderChat = new BanChatSenderChat(
                new BanChatSenderChatBody(159L, 159L)
        );

        Assertions.assertEquals(banChatSenderChat.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("banChatSenderChat", banChatSenderChat.getMethod());
        Assertions.assertTrue(banChatSenderChat.getBody().isPresent());
    }
}
