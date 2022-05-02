package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record SetChatDescriptionBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("description") Optional<String> description
) {
}
