package dev.tobee.telegram.request.sendobject;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendContactBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendContactTest {

    @Test
    void checkValidRequest() {
        SendContact sendContact = new SendContact(
                new SendContactBody(159L, "eval", "First", Optional.empty(), Optional.empty(), Optional.empty(),
                        Optional.empty(),
                        OptionalInt.empty(), Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(sendContact.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendContact", sendContact.getMethod());
        Assertions.assertTrue(sendContact.getBody().isPresent());
    }
}
