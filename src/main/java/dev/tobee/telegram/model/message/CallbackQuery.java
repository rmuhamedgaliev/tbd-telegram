package dev.tobee.telegram.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CallbackQuery(
        @JsonProperty("id") String id,
        @JsonProperty("from") User from,
        @JsonProperty("message") Message message,
        @JsonProperty("inline_message_id") String inlineMessageId,
        @JsonProperty("chat_instance") String chatInstance,
        @JsonProperty("data") String data,
        @JsonProperty("game_short_name") String gameShortName
) {
}
