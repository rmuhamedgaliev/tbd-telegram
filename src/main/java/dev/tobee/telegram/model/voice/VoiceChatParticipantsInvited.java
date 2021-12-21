package dev.tobee.telegram.model.voice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record VoiceChatParticipantsInvited(
        @JsonProperty("users") List<User> users
) {
}
