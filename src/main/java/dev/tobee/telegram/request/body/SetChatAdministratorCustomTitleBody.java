package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetChatAdministratorCustomTitleBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("user_id") int userId,
        @JsonProperty("custom_title") String customTitle
) {
}
