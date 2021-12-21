package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.ApproveChatJoinRequestBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApproveChatJoinRequestTest {

    @Test
    void checkValidRequest() {
        ApproveChatJoinRequest approveChatJoinRequest = new ApproveChatJoinRequest(
                new ApproveChatJoinRequestBody(159L, 159L)
        );

        Assertions.assertEquals(approveChatJoinRequest.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("approveChatJoinRequest", approveChatJoinRequest.getMethod());
        Assertions.assertTrue(approveChatJoinRequest.getBody().isPresent());
    }
}
