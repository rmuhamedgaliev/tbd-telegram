package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

public record SendLocationBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("latitude") float latitude,
        @JsonProperty("longitude") float longitude,
        @JsonProperty("horizontal_accuracy") float horizontalAccuracy,
        @JsonProperty("live_period") OptionalInt livePeriod,
        @JsonProperty("heading") OptionalInt heading,
        @JsonProperty("proximity_alert_radius") OptionalInt proximityAlertRadius,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("protect_content") Optional<Boolean> protectContent,
        @JsonProperty("reply_to_message_id") OptionalLong replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
