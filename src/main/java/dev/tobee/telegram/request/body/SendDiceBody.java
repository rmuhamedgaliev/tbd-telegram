package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.DiceEmoji;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.Optional;

public record SendDiceBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("emoji") Optional<DiceEmoji> emoji,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}