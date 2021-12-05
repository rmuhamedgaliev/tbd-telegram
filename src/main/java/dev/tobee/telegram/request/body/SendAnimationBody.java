package dev.tobee.telegram.request.body;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.InputFile;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ReplyMarkup;

public record SendAnimationBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("animation") InputFile animation,
        @JsonProperty("duration") OptionalInt duration,
        @JsonProperty("width") OptionalInt width,
        @JsonProperty("height") OptionalInt height,
        @JsonProperty("thumb") Optional<Path> thumb,
        @JsonProperty("caption") Optional<String> caption,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("caption_entities") List<MessageEntity> entities,
        @JsonProperty("supports_streaming") Optional<Boolean> supportsStreaming,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") OptionalInt replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
