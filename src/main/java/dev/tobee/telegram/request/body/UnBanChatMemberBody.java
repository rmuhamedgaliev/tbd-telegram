package dev.tobee.telegram.request.body;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UnBanChatMemberBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("user_id") int userId,
        @JsonProperty("only_if_banned") Optional<Boolean> onlyIfBanned
) {
}
