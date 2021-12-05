package dev.tobee.telegram.request.comands;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.BotCommand;
import dev.tobee.telegram.model.BotCommandScopeDefault;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetMyCommandsBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteMyCommandsTest{

    @Test
    void checkValidRequest() {
        SetMyCommands setMyCommands = new SetMyCommands(
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

        Assertions.assertEquals(setMyCommands.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("setMyCommands", setMyCommands.getMethod());
        Assertions.assertTrue(setMyCommands.getBody().isPresent());
        Assertions.assertTrue(setMyCommands.getBody().get().containsKey("scope"));
        Assertions.assertTrue(setMyCommands.getBody().get().get("scope") instanceof String);
    }
}
