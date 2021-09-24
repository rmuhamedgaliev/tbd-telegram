package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.Optional;
import java.util.OptionalLong;

public record StopMessageLiveLocationBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("message_id") OptionalLong messageId,
        @JsonProperty("inline_message_id") OptionalLong inlineMessageId,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}