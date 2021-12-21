package dev.tobee.telegram.request.message;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.EditMessageTextBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditMessageTextTest {

    @Test
    void checkValidRequest() {
        EditMessageText editMessageText = new EditMessageText(
                new EditMessageTextBody(159L, OptionalLong.of(159L), Optional.empty(), "", Optional.empty(),
                        Collections.emptyList(), Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(editMessageText.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("editMessageText", editMessageText.getMethod());
        Assertions.assertTrue(editMessageText.getBody().isPresent());
    }
}
