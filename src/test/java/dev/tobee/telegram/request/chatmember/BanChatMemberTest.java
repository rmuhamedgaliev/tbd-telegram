package dev.tobee.telegram.request.chatmember;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.BanChatMemberBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BanChatMemberTest {

    @Test
    void checkValidRequest() {
        BanChatMember banChatMember = new BanChatMember(
                new BanChatMemberBody(159L, 159L, OptionalLong.empty(), Optional.empty())
        );

        Assertions.assertEquals(banChatMember.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("banChatMember", banChatMember.getMethod());
        Assertions.assertTrue(banChatMember.getBody().isPresent());
    }
}
