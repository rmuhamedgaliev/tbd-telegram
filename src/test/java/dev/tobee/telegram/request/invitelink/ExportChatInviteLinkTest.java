package dev.tobee.telegram.request.invitelink;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.ExportChatInviteLinkBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExportChatInviteLinkTest {

    @Test
    void checkValidRequest() {
        ExportChatInviteLink exportChatInviteLink = new ExportChatInviteLink(
                new ExportChatInviteLinkBody(159L)
        );

        Assertions.assertEquals(exportChatInviteLink.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<String>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("exportChatInviteLink", exportChatInviteLink.getMethod());
        Assertions.assertTrue(exportChatInviteLink.getBody().isPresent());
    }
}
