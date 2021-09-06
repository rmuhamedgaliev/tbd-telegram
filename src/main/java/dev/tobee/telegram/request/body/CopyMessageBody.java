package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public record CopyMessageBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("from_chat_id") int fromChatId,
        @JsonProperty("message_id") int messageId,
        @JsonProperty("caption") Optional<String> caption,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("caption_entities") List<MessageEntity> captionEntities,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") OptionalInt replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
        ) {
}
