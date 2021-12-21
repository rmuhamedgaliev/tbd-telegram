package dev.tobee.telegram.request.body;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record StopPollBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") Long message_id,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
