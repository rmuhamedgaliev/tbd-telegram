package dev.tobee.telegram.request.chatmember;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.GetChatMemberCountBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetChatMemberCountTest {

    @Test
    void checkValidRequest() {
        GetChatMemberCount getChatMemberCount = new GetChatMemberCount(
                new GetChatMemberCountBody(159L)
        );

        Assertions.assertEquals(getChatMemberCount.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Long>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("getChatMemberCount", getChatMemberCount.getMethod());
        Assertions.assertTrue(getChatMemberCount.getBody().isPresent());
    }
}
