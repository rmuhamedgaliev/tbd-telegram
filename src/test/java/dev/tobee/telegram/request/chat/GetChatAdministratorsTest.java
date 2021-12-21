package dev.tobee.telegram.request.chat;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatMember;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.GetChatAdministratorsBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetChatAdministratorsTest {

    @Test
    void checkValidRequest() {
        GetChatAdministrators getChatAdministrators = new GetChatAdministrators(
                new GetChatAdministratorsBody(159L)
        );

        Assertions.assertEquals(getChatAdministrators.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<List<ChatMember>>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("getChatAdministrators", getChatAdministrators.getMethod());
        Assertions.assertTrue(getChatAdministrators.getBody().isPresent());
    }
}
