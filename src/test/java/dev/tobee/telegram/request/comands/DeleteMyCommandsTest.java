package dev.tobee.telegram.request.comands;

import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.DeleteMyCommandsBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteMyCommandsTest {

    @Test
    void checkValidRequest() {
        DeleteMyCommands deleteMyCommands = new DeleteMyCommands(
                new DeleteMyCommandsBody(
                        Optional.empty(),
                        Optional.empty()
                )
        );

        Assertions.assertEquals(deleteMyCommands.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("deleteMyCommands", deleteMyCommands.getMethod());
        Assertions.assertTrue(deleteMyCommands.getBody().isPresent());
    }
}
