package dev.tobee.telegram.request.body;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetChatDescriptionBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("description") Optional<String> description
) {
}
