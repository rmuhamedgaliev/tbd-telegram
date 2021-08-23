package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public record SendMessageBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("text") String text,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("entities") List<MessageEntity> entities,
        @JsonProperty("disable_web_page_preview") Optional<Boolean> disableWebPagePreview,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<String> replyMarkup
) {
}
