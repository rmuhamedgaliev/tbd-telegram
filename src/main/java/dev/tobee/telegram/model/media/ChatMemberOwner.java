package dev.tobee.telegram.model.media;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.chat.ChatMember;
import dev.tobee.telegram.model.message.User;

public record ChatMemberOwner(
        @JsonProperty("status") String status,
        @JsonProperty("user") User user,
        @JsonProperty("is_anonymous") boolean isAnonymous,
        @JsonProperty("custom_title") Optional<String> customTitle
) implements ChatMember {
}
