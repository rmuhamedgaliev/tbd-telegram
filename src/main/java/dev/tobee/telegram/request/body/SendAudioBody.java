package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.InputFile;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.PhotoSize;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public record SendAudioBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("audio") InputFile audio,
        @JsonProperty("caption") Optional<String> caption,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("caption_entities") List<MessageEntity> entities,
        @JsonProperty("duration") int duration,
        @JsonProperty("performer") Optional<String> performer,
        @JsonProperty("title") Optional<String> title,
        @JsonProperty("file_size") OptionalInt fileSize,
        @JsonProperty("thumb") Optional<PhotoSize> thumb,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
