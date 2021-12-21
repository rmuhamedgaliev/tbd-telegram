package dev.tobee.telegram.request.body;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.MessageEntity;
import dev.tobee.telegram.model.message.ParseMode;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record CopyMessageBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("from_chat_id") long fromChatId,
        @JsonProperty("message_id") long messageId,
        @JsonProperty("caption") Optional<String> caption,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("caption_entities") List<MessageEntity> captionEntities,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") OptionalLong replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
