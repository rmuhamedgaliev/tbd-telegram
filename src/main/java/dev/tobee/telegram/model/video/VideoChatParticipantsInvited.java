package dev.tobee.telegram.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

import java.util.List;

public record VideoChatParticipantsInvited(
        @JsonProperty("users") List<User> users
) {
}
