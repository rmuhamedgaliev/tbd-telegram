package dev.tobee.telegram.request.body;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ReplyMarkup;

public record StopMessageLiveLocationBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") OptionalLong messageId,
        @JsonProperty("inline_message_id") OptionalLong inlineMessageId,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
