package dev.tobee.telegram.request.sendobject;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendPollBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendPollTest {

    @Test
    void checkValidRequest() {
        SendPoll sendPoll = new SendPoll(
                new SendPollBody(159L, "question", List.of(), Optional.empty(), Optional.empty(), Optional.empty(),
                        OptionalInt.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                        OptionalInt.empty(), OptionalInt.empty(), Optional.empty(), Optional.empty(),
                        OptionalInt.empty(), Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(sendPoll.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendPoll", sendPoll.getMethod());
        Assertions.assertTrue(sendPoll.getBody().isPresent());
    }
}
