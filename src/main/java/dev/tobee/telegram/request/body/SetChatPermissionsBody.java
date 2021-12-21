package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.chat.ChatPermissions;

public record SetChatPermissionsBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("permissions") ChatPermissions permissions
) {
}
