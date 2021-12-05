package dev.tobee.telegram.request.body;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ReplyMarkup;
import org.apache.commons.text.StringEscapeUtils;

public record SendMessageBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("text") String text,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("entities") List<MessageEntity> entities,
        @JsonProperty("disable_web_page_preview") Optional<Boolean> disableWebPagePreview,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") OptionalInt replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {

    @Override
    public String text() {
        return StringEscapeUtils.escapeJava(text);
    }
}
