package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.chat.ChatMember;
import dev.tobee.telegram.model.message.User;

public record ChatMemberLeft(
        @JsonProperty("status") String status,
        @JsonProperty("user") User user
) implements ChatMember {
}
