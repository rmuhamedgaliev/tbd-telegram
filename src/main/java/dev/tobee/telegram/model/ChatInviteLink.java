package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.OptionalInt;

public record ChatInviteLink(
        @JsonProperty("invite_link") String inviteLink,
        @JsonProperty("creator") User creator,
        @JsonProperty("is_primary") boolean isPrimary,
        @JsonProperty("is_revoked") boolean isRevoked,
        @JsonProperty("expire_date") OptionalInt expireDate,
        @JsonProperty("member_limit") OptionalInt memberLimit
) {
}
