package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record ChatMemberUpdated(
        @JsonProperty("chat") Chat chat,
        @JsonProperty("from") User user,
        @JsonProperty("date") int date,
        @JsonProperty("old_chat_member") ChatMember oldChatMember,
        @JsonProperty("new_chat_member") ChatMember newChatMember,
        @JsonProperty("invite_link") Optional<ChatInviteLink> inviteLink
) {
}
