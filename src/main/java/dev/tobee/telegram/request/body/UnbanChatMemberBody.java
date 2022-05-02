package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record UnbanChatMemberBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("user_id") long userId,
        @JsonProperty("only_if_banned") Optional<Boolean> onlyIfBanned
) {
}
