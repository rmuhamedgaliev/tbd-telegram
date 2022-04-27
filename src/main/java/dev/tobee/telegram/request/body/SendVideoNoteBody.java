package dev.tobee.telegram.request.body;

import java.nio.file.Path;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.InputFile;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record SendVideoNoteBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("video_note") InputFile audio,
        @JsonProperty("duration") OptionalInt duration,
        @JsonProperty("length") OptionalInt length,
        @JsonProperty("thumb") Optional<Path> thumb,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("protect_content") Optional<Boolean> protectContent,
        @JsonProperty("reply_to_message_id") OptionalLong replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
