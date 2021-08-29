package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record VoiceChatParticipantsInvited(
        @JsonProperty("users") List<User> users
) {
}
