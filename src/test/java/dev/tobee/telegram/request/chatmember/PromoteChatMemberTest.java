package dev.tobee.telegram.request.chatmember;

import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.PromoteChatMemberBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PromoteChatMemberTest {

    @Test
    void checkValidRequest() {
        PromoteChatMember promoteChatMember = new PromoteChatMember(
                new PromoteChatMemberBody(159L, 159L, Optional.empty(), Optional.empty(), Optional.empty(),
                        Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                        Optional.empty(), Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(promoteChatMember.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("promoteChatMember", promoteChatMember.getMethod());
        Assertions.assertTrue(promoteChatMember.getBody().isPresent());
    }
}
