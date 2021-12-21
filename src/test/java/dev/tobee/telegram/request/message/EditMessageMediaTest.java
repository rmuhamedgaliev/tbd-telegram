package dev.tobee.telegram.request.message;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.EditMessageMediaBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditMessageMediaTest {

    @Test
    void checkValidRequest() {
        EditMessageMedia editMessageMedia = new EditMessageMedia(
                new EditMessageMediaBody(159L, OptionalLong.of(159L), Optional.empty(), "", Optional.empty())
        );

        Assertions.assertEquals(editMessageMedia.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("editMessageMedia", editMessageMedia.getMethod());
        Assertions.assertTrue(editMessageMedia.getBody().isPresent());
    }
}
