package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SetChatTitleBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetChatTitleTest {

    @Test
    void checkValidRequest() {
        SetChatTitle setChatTitle = new SetChatTitle(
                new SetChatTitleBody(159L, "Title")
        );

        Assertions.assertEquals(setChatTitle.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("setChatTitle", setChatTitle.getMethod());
        Assertions.assertTrue(setChatTitle.getBody().isPresent());
    }
}
