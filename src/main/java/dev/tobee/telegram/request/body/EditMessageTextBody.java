package dev.tobee.telegram.request.body;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.MessageEntity;
import dev.tobee.telegram.model.message.ParseMode;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record EditMessageTextBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("message_id") OptionalLong messageId,
        @JsonProperty("inline_message_id") Optional<String> inlineMessageId,
        @JsonProperty("text") String text,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("entities") List<MessageEntity> entities,
        @JsonProperty("disable_web_page_preview") Optional<Boolean> disableWebPagePreview,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
