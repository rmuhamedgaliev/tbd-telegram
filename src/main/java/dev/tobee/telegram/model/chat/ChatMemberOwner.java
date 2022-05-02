package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

import java.util.Optional;

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
