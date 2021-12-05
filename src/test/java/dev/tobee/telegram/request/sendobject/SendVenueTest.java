package dev.tobee.telegram.request.sendobject;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.Message;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SendVenueBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendVenueTest {

    @Test
    void checkValidRequest() throws IOException {
        SendVenue sendVenue = new SendVenue(
                new SendVenueBody(159L, 0.4f, 0.4f, "title", "address", Optional.empty(), Optional.empty(),
                        Optional.empty(), Optional.empty(), Optional.empty(), OptionalInt.empty(), Optional.empty(),
                        Optional.empty()));

        Assertions.assertEquals(sendVenue.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendVenue", sendVenue.getMethod());
        Assertions.assertTrue(sendVenue.getBody().isPresent());
    }
}
