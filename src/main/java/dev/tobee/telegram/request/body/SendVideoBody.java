package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.InputFile;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public record SendVideoBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("video") InputFile audio,
        @JsonProperty("duration") OptionalInt duration,
        @JsonProperty("width") OptionalInt width,
        @JsonProperty("height") OptionalInt height,
        @JsonProperty("thumb") InputFile thumb,
        @JsonProperty("caption") Optional<String> caption,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("caption_entities") List<MessageEntity> entities,
        @JsonProperty("supports_streaming") Optional<Boolean> supportsStreaming,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
