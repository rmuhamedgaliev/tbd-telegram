package dev.tobee.telegram.request.body;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EditChatInviteLinkBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("invite_link") String inviteLink,
        @JsonProperty("name") Optional<String> name,
        @JsonProperty("expire_date") OptionalLong expireDate,
        @JsonProperty("member_limit") OptionalInt memberLimit,
        @JsonProperty("creates_join_request") Optional<Boolean> createsJoinRequest
) {
}
