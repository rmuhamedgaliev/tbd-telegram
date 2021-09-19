package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.InputFile;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.List;
import java.util.Optional;

public record SendPhotoBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("photo") InputFile photo,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("caption_entities") List<MessageEntity> captionEntities,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
