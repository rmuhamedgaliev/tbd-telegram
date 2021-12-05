package dev.tobee.telegram.request.message;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.Message;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.StopMessageLiveLocationBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StopMessageLiveLocationTest {

    @Test
    void checkValidRequest() {
        StopMessageLiveLocation stopMessageLiveLocation = new StopMessageLiveLocation(
                new StopMessageLiveLocationBody(159L, OptionalLong.of(159L), OptionalLong.empty(), Optional.empty())
        );

        Assertions.assertEquals(stopMessageLiveLocation.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {}).getType().getTypeName());
        Assertions.assertEquals("stopMessageLiveLocation", stopMessageLiveLocation.getMethod());
        Assertions.assertTrue(stopMessageLiveLocation.getBody().isPresent());
    }
}
