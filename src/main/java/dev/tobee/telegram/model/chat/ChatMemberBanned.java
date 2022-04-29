package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record ChatMemberBanned(
        @JsonProperty("status") ChatMemberStatus status,
        @JsonProperty("user") User user,
        @JsonProperty("until_date") long untilDate
) implements ChatMember {

    @Override
    public ChatMemberStatus status() {
        return status;
    }
}
