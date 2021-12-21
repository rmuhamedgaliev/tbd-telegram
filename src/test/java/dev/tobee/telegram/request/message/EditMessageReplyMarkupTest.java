package dev.tobee.telegram.request.message;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.EditMessageReplyMarkupBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditMessageReplyMarkupTest {

    @Test
    void checkValidRequest() {
        EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup(
                new EditMessageReplyMarkupBody(159L, OptionalLong.of(159L), Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(editMessageReplyMarkup.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("editMessageReplyMarkup", editMessageReplyMarkup.getMethod());
        Assertions.assertTrue(editMessageReplyMarkup.getBody().isPresent());
    }
}
