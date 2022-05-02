package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

public record ChatInviteLink(
        @JsonProperty("invite_link") String inviteLink,
        @JsonProperty("creator") User creator,
        @JsonProperty("creates_join_request") boolean createsJoinRequest,
        @JsonProperty("is_primary") boolean isPrimary,
        @JsonProperty("is_revoked") boolean isRevoked,
        @JsonProperty("name") Optional<String> name,
        @JsonProperty("expire_date") OptionalLong expireDate,
        @JsonProperty("member_limit") OptionalInt memberLimit,
        @JsonProperty("pending_join_request_count") OptionalInt pendingJoinRequestCount
) {
}
