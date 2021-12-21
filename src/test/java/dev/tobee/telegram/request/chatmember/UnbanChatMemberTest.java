package dev.tobee.telegram.request.chatmember;

import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.UnbanChatMemberBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnbanChatMemberTest {

    @Test
    void checkValidRequest() {
        UnbanChatMember unbanChatMember = new UnbanChatMember(
                new UnbanChatMemberBody(159L, 159L, Optional.empty())
        );

        Assertions.assertEquals(unbanChatMember.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("unbanChatMember", unbanChatMember.getMethod());
        Assertions.assertTrue(unbanChatMember.getBody().isPresent());
    }
}
