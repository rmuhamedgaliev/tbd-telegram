package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalLong;

public record BanChatMemberBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("user_id") int userId,
        @JsonProperty("until_date") OptionalLong untilDate,
        @JsonProperty("revoke_messages")Optional<Boolean> revokeMessages
        ) {
}
