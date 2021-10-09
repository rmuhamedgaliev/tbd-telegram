package dev.tobee.telegram.request.body;

import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateChatInviteLinkBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("expire_date") OptionalLong expireDate,
        @JsonProperty("member_limit") OptionalInt memberLimit
) {
}
