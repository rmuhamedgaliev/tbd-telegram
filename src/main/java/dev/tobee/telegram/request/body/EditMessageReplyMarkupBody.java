package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

import java.util.Optional;
import java.util.OptionalLong;

public record EditMessageReplyMarkupBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") OptionalLong messageId,
        @JsonProperty("inline_message_id") Optional<String> inlineMessageId,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
