package dev.tobee.telegram.request.chat;

import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ChatPermissions;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetChatPermissionsBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetChatPermissionsTest {

    @Test
    void checkValidRequest() {
        SetChatPermissions setChatPermissions = new SetChatPermissions(
                new SetChatPermissionsBody(159L, new ChatPermissions(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()))
        );

        Assertions.assertEquals(setChatPermissions.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("setChatPermissions", setChatPermissions.getMethod());
        Assertions.assertTrue(setChatPermissions.getBody().isPresent());
    }
}
