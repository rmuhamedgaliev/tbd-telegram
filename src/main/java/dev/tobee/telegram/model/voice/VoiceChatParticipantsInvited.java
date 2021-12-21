package dev.tobee.telegram.model.voice;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

import java.util.List;

public record VoiceChatParticipantsInvited(
        @JsonProperty("users") List<User> users
) {
}
