package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

public record EditMessageLiveLocationBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("message_id") OptionalLong messageId,
        @JsonProperty("inline_message_id") OptionalLong inlineMessageId,
        @JsonProperty("latitude") float latitude,
        @JsonProperty("longitude") float longitude,
        @JsonProperty("horizontal_accuracy") float horizontalAccuracy,
        @JsonProperty("heading") OptionalInt heading,
        @JsonProperty("proximity_alert_radius") OptionalInt proximityAlertRadius,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
