package dev.tobee.telegram.request.invitelink;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.CreateChatInviteLinkBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateChatInviteLinkTest {

    @Test
    void checkValidRequest() {
        CreateChatInviteLink createChatInviteLink = new CreateChatInviteLink(
                new CreateChatInviteLinkBody(159L, Optional.empty(), OptionalLong.empty(), OptionalInt.empty(), Optional.empty())
        );

        Assertions.assertEquals(createChatInviteLink.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("createChatInviteLink", createChatInviteLink.getMethod());
        Assertions.assertTrue(createChatInviteLink.getBody().isPresent());
    }
}
