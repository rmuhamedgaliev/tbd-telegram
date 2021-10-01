package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ChatPermissions;

import java.util.OptionalLong;

public record RestrictChatMemberBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("user_id") int userId,
        @JsonProperty("permissions") ChatPermissions permissions,
        @JsonProperty("until_date") OptionalLong untilDate
) {
}
