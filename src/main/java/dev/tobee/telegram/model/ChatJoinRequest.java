package dev.tobee.telegram.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatJoinRequest(
        @JsonProperty("chat") Chat chat,
        @JsonProperty("from") User from,
        @JsonProperty("date") long date,
        @JsonProperty("bio") Optional<String> bio,
        @JsonProperty("invite_link") Optional<ChatInviteLink> inviteLink
) {
}
