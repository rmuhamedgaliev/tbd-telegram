package dev.tobee.telegram.request.sendobject;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendLocationBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendLocationTest {

    @Test
    void checkValidRequest() {
        SendLocation sendLocation = new SendLocation(new SendLocationBody(159L, 0.4f, 0.4f, 0.4f, OptionalInt.empty()
                , OptionalInt.empty(), OptionalInt.empty(), Optional.empty(), Optional.empty(), OptionalLong.empty(),
                Optional.empty(),
                Optional.empty()));

        Assertions.assertEquals(sendLocation.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendLocation", sendLocation.getMethod());
        Assertions.assertTrue(sendLocation.getBody().isPresent());
    }
}
