package dev.tobee.telegram.model.video;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record VideoChatParticipantsInvited(
        @JsonProperty("users") List<User> users
) {
}
