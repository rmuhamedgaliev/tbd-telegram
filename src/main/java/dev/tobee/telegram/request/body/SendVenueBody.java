package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ReplyMarkup;

import java.util.Optional;

public record SendVenueBody(
        @JsonProperty("chat_id") int chatId,
        @JsonProperty("latitude") float latitude,
        @JsonProperty("longitude") float longitude,
        @JsonProperty("title") String title,
        @JsonProperty("address") String address,
        @JsonProperty("foursquare_id") Optional<String> foursquareId,
        @JsonProperty("foursquare_type") Optional<String> foursquareType,
        @JsonProperty("google_place_id") Optional<String> googlePlaceId,
        @JsonProperty("google_place_type") Optional<String> googlePlaceType,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
