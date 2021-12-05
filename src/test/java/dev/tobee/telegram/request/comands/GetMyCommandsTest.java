package dev.tobee.telegram.request.comands;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.BotCommand;
import dev.tobee.telegram.model.BotCommandScopeDefault;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.GetMyCommandsBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetMyCommandsTest {

    @Test
    void checkValidRequest() {
        GetMyCommands getMyCommands = new GetMyCommands(
                new GetMyCommandsBody(
                        Optional.of(new BotCommandScopeDefault()),
                        Optional.empty()
                )
        );

        Assertions.assertEquals(getMyCommands.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<List<BotCommand>>>() {}).getType().getTypeName());
        Assertions.assertEquals("getMyCommands", getMyCommands.getMethod());
        Assertions.assertTrue(getMyCommands.getBody().isPresent());
        Assertions.assertTrue(getMyCommands.getBody().get().containsKey("scope"));
        Assertions.assertTrue(getMyCommands.getBody().get().get("scope") instanceof String);
    }
}
