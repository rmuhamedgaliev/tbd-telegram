package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ChatPermissions;

public record SetChatPermissionsBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("permissions") ChatPermissions permissions
) {
}
