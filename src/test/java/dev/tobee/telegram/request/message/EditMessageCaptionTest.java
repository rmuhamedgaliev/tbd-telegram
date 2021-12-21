package dev.tobee.telegram.request.message;

import java.util.Collections;
import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.EditMessageCaptionBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditMessageCaptionTest {

    @Test
    void checkValidRequest() {
        EditMessageCaption editMessageCaption = new EditMessageCaption(
                new EditMessageCaptionBody(159L, OptionalLong.of(159L), Optional.empty(), Optional.empty(),
                        Optional.empty(), Collections.emptyList(), Optional.empty())
        );

        Assertions.assertEquals(editMessageCaption.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("editMessageCaption", editMessageCaption.getMethod());
        Assertions.assertTrue(editMessageCaption.getBody().isPresent());
    }
}
