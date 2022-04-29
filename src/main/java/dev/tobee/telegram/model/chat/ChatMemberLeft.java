package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record ChatMemberLeft(
        @JsonProperty("status") ChatMemberStatus status,
        @JsonProperty("user") User user
) implements ChatMember {

    @Override
    public ChatMemberStatus status() {
        return status;
    }
}
