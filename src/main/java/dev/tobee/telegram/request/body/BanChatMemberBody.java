package dev.tobee.telegram.request.body;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BanChatMemberBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("user_id") long userId,
        @JsonProperty("until_date") OptionalLong untilDate,
        @JsonProperty("revoke_messages") Optional<Boolean> revokeMessages
) {
}
