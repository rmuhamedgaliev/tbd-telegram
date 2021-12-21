package dev.tobee.telegram.request.comands;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.bot.BotCommand;
import dev.tobee.telegram.model.bot.BotCommandScopeDefault;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SetMyCommandsBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetMyCommandsTest {

    @Test
    void checkValidRequest() {
        SetMyCommands getMyCommands = new SetMyCommands(
                new SetMyCommandsBody(
                        List.of(
                                new BotCommand(
                                        "auth",
                                        "description"
                                )
                        ),
                        Optional.of(new BotCommandScopeDefault()),
                        Optional.empty()
                )
        );

        Assertions.assertEquals(getMyCommands.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
        }).getType().getTypeName());
        Assertions.assertEquals("setMyCommands", getMyCommands.getMethod());
        Assertions.assertTrue(getMyCommands.getBody().isPresent());
        Assertions.assertTrue(getMyCommands.getBody().get().containsKey("scope"));
        Assertions.assertTrue(getMyCommands.getBody().get().get("scope") instanceof String);
    }

}
