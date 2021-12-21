package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.DeclineChatJoinRequestBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeclineChatJoinRequestTest {

    @Test
    void checkValidRequest() {
        DeclineChatJoinRequest declineChatJoinRequest = new DeclineChatJoinRequest(
                new DeclineChatJoinRequestBody(159L, 159L)
        );

        Assertions.assertEquals(declineChatJoinRequest.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("declineChatJoinRequest", declineChatJoinRequest.getMethod());
        Assertions.assertTrue(declineChatJoinRequest.getBody().isPresent());
    }
}
