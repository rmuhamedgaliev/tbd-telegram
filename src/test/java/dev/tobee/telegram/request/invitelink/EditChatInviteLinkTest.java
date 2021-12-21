package dev.tobee.telegram.request.invitelink;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.EditChatInviteLinkBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditChatInviteLinkTest {

    @Test
    void checkValidRequest() {
        EditChatInviteLink editChatInviteLink = new EditChatInviteLink(
                new EditChatInviteLinkBody(159L, "https://beguncx.tvx", Optional.empty(), OptionalLong.empty(), OptionalInt.empty(), Optional.empty())
        );

        Assertions.assertEquals(editChatInviteLink.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("editChatInviteLink", editChatInviteLink.getMethod());
        Assertions.assertTrue(editChatInviteLink.getBody().isPresent());
    }
}
