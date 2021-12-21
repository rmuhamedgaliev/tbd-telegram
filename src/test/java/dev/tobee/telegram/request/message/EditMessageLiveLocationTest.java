package dev.tobee.telegram.request.message;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.EditMessageLiveLocationBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditMessageLiveLocationTest {

    @Test
    void checkValidRequest() {
        EditMessageLiveLocation editMessageLiveLocation = new EditMessageLiveLocation(
                new EditMessageLiveLocationBody(159L, OptionalLong.empty(), OptionalLong.empty(), 0.02008684613f, 0.02008684613f, 0.5f, OptionalInt.empty(), OptionalInt.empty(), Optional.empty())
        );

        Assertions.assertEquals(editMessageLiveLocation.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {}).getType().getTypeName());
        Assertions.assertEquals("editMessageLiveLocation", editMessageLiveLocation.getMethod());
        Assertions.assertTrue(editMessageLiveLocation.getBody().isPresent());
    }
}
