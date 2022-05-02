package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.chat.ChatPermissions;

import java.util.OptionalLong;

public record RestrictChatMemberBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("user_id") long userId,
        @JsonProperty("permissions") ChatPermissions permissions,
        @JsonProperty("until_date") OptionalLong untilDate
) {
}
