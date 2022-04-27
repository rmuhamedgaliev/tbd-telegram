package dev.tobee.telegram.request.sendobject;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.media.DiceEmoji;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendDiceBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendDiceTest {

    @Test
    void checkValidRequest() {
        SendDice sendDice = new SendDice(
                new SendDiceBody(159L, Optional.of(DiceEmoji.DIRECT_HIT), Optional.empty(), Optional.empty(),
                        OptionalLong.empty(),
                        Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(sendDice.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendDice", sendDice.getMethod());
        Assertions.assertTrue(sendDice.getBody().isPresent());
    }
}
