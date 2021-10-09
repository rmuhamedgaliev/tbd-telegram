package dev.tobee.telegram.model;

import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatInviteLink(
        @JsonProperty("invite_link") String inviteLink,
        @JsonProperty("creator") User creator,
        @JsonProperty("is_primary") boolean isPrimary,
        @JsonProperty("is_revoked") boolean isRevoked,
        @JsonProperty("expire_date") OptionalLong expireDate,
        @JsonProperty("member_limit") OptionalInt memberLimit
) {
}
