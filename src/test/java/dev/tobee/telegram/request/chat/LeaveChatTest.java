package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.LeaveChatBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeaveChatTest {

    @Test
    void checkValidRequest() {
        LeaveChat leaveChat = new LeaveChat(
                new LeaveChatBody(159L)
        );

        Assertions.assertEquals(leaveChat.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("leaveChat", leaveChat.getMethod());
        Assertions.assertTrue(leaveChat.getBody().isPresent());
    }
}
