package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RevokeChatInviteLinkBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("invite_link") String inviteLink
) {
}
