package dev.tobee.telegram.model.chat;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record ChatMemberOwner(
        @JsonProperty("status") ChatMemberStatus status,
        @JsonProperty("user") User user,
        @JsonProperty("is_anonymous") boolean isAnonymous,
        @JsonProperty("custom_title") Optional<String> customTitle
) implements ChatMember {

    @Override
    public ChatMemberStatus status() {
        return status;
    }
}
