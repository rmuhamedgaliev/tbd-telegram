package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetChatAdministratorCustomTitleBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetChatAdministratorCustomTitleTest {

    @Test
    void checkValidRequest() {
        SetChatAdministratorCustomTitle setChatAdministratorCustomTitle = new SetChatAdministratorCustomTitle(
                new SetChatAdministratorCustomTitleBody(159L, 159L, "title")
        );

        Assertions.assertEquals(setChatAdministratorCustomTitle.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("setChatAdministratorCustomTitle", setChatAdministratorCustomTitle.getMethod());
        Assertions.assertTrue(setChatAdministratorCustomTitle.getBody().isPresent());
    }
}
