package dev.tobee.telegram.request.chatmember;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ChatPermissions;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.RestrictChatMemberBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestrictChatMemberTest {

    @Test
    void checkValidRequest() {
        RestrictChatMember restrictChatMember = new RestrictChatMember(
                new RestrictChatMemberBody(159L, 159L, new ChatPermissions(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()), OptionalLong.empty())
        );

        Assertions.assertEquals(restrictChatMember.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("restrictChatMember", restrictChatMember.getMethod());
        Assertions.assertTrue(restrictChatMember.getBody().isPresent());
    }
}
