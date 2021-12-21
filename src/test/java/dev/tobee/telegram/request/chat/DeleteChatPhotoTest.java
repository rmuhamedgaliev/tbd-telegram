package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.DeleteChatPhotoBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteChatPhotoTest {

    @Test
    void checkValidRequest() {
        DeleteChatPhoto deleteChatPhoto = new DeleteChatPhoto(
                new DeleteChatPhotoBody(159L)
        );

        Assertions.assertEquals(deleteChatPhoto.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("deleteChatPhoto", deleteChatPhoto.getMethod());
        Assertions.assertTrue(deleteChatPhoto.getBody().isPresent());
    }
}
