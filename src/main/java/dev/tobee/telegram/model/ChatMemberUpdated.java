package dev.tobee.telegram.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatMemberUpdated(
        @JsonProperty("chat") Chat chat,
        @JsonProperty("from") User user,
        @JsonProperty("date") long date,
        @JsonProperty("old_chat_member") ChatMember oldChatMember,
        @JsonProperty("new_chat_member") ChatMember newChatMember,
        @JsonProperty("invite_link") Optional<ChatInviteLink> inviteLink
) {
}
