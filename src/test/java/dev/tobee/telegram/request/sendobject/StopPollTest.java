package dev.tobee.telegram.request.sendobject;

import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.StopPollBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StopPollTest {

    @Test
    void checkValidRequest() {
        StopPoll sendPoll = new StopPoll(
                new StopPollBody(159L, 159L, Optional.empty())
        );

        Assertions.assertEquals(sendPoll.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("stopPoll", sendPoll.getMethod());
        Assertions.assertTrue(sendPoll.getBody().isPresent());
    }
}
