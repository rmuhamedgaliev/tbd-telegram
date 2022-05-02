package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.DiceEmoji;
import dev.tobee.telegram.model.message.ReplyMarkup;

import java.util.Optional;
import java.util.OptionalLong;

public record SendDiceBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("emoji") Optional<DiceEmoji> emoji,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("protect_content") Optional<Boolean> protectContent,
        @JsonProperty("reply_to_message_id") OptionalLong replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
