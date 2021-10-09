package dev.tobee.telegram.request.body;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.ReplyMarkup;

public record SendContactBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") Optional<String> lastName,
        @JsonProperty("vcard") Optional<String> vcard,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("reply_to_message_id") Optional<Integer> replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
