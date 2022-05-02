package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

import java.util.Optional;

public record StopPollBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") Long message_id,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
