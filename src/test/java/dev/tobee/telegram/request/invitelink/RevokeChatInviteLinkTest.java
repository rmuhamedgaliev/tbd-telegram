package dev.tobee.telegram.request.invitelink;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatInviteLink;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.RevokeChatInviteLinkBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RevokeChatInviteLinkTest {

    @Test
    void checkValidRequest() {
        RevokeChatInviteLink revokeChatInviteLink = new RevokeChatInviteLink(
                new RevokeChatInviteLinkBody(159L, "https://complex8duhqvuj.zcw")
        );

        Assertions.assertEquals(revokeChatInviteLink.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<ChatInviteLink>>() {}).getType().getTypeName());
        Assertions.assertEquals("revokeChatInviteLink", revokeChatInviteLink.getMethod());
        Assertions.assertTrue(revokeChatInviteLink.getBody().isPresent());
    }
}
