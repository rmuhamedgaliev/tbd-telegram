package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApproveChatJoinRequestBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("user_id") long userId
) {
}
