package dev.tobee.telegram.request.chatmember;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatMember;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.GetChatMemberBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetChatMemberTest {

    @Test
    void checkValidRequest() {
        GetChatMember getChatMember = new GetChatMember(
                new GetChatMemberBody(159L, 159L)
        );

        Assertions.assertEquals(getChatMember.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<ChatMember>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("getChatMember", getChatMember.getMethod());
        Assertions.assertTrue(getChatMember.getBody().isPresent());
    }
}
