package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.PollType;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public record SendPollBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("question") String question,
        @JsonProperty("options") List<String> options,
        @JsonProperty("is_anonymous") Optional<Boolean> isAnonymous,
        @JsonProperty("type") Optional<PollType> type,
        @JsonProperty("allows_multiple_answers") Optional<Boolean> allowsMultipleAnswers,
        @JsonProperty("correct_option_id") Optional<Integer> correctOptionId,
        @JsonProperty("explanation") Optional<String> explanation,
        @JsonProperty("explanation_parse_mode") Optional<ParseMode> explanationParseMode,
        @JsonProperty("explanation_entities") Optional<List<MessageEntity>> explanationEntities,
        @JsonProperty("open_period") OptionalInt openPeriod,
        @JsonProperty("close_date") OptionalInt closeDate,
        @JsonProperty("is_closed") Optional<Boolean> isClosed,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
