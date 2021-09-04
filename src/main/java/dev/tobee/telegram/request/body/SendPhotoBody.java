package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public record SendPhotoBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("photo") Path photo,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("entities") List<MessageEntity> entities,
        @JsonProperty("disable_web_page_preview") Optional<Boolean> disableWebPagePreview,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply
) {
}
