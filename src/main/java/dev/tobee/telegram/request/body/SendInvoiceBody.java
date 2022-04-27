package dev.tobee.telegram.request.body;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.LabeledPrice;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record SendInvoiceBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("title") String title,
        @JsonProperty("description") String description,
        @JsonProperty("payload") String payload,
        @JsonProperty("provider_token") String providerToken,
        @JsonProperty("currency") String currency,
        @JsonProperty("prices") List<LabeledPrice> prices,
        @JsonProperty("max_tip_amount") OptionalInt maxTipAmount,
        @JsonProperty("suggested_tip_amounts") List<OptionalInt> suggestedTipAmounts,
        @JsonProperty("start_parameter") Optional<String> startParameter,
        @JsonProperty("provider_data") Optional<String> providerData,
        @JsonProperty("photo_url") Optional<String> photoUrl,
        @JsonProperty("photo_size") OptionalInt photoSize,
        @JsonProperty("photo_width") OptionalInt photoWidth,
        @JsonProperty("photo_height") OptionalInt photoHeight,
        @JsonProperty("need_name") Optional<Boolean> needName,
        @JsonProperty("need_email") Optional<Boolean> needEmail,
        @JsonProperty("need_shipping_address") Optional<Boolean> needShippingAddress,
        @JsonProperty("send_phone_number_to_provider") Optional<Boolean> sendPhoneNumberToProvider,
        @JsonProperty("send_email_to_provider") Optional<Boolean> sendEmailToProvider,
        @JsonProperty("is_flexible") Optional<Boolean> isFlexible,
        @JsonProperty("disable_notification") Optional<Boolean> disableNotification,
        @JsonProperty("protect_content") Optional<Boolean> protectContent,
        @JsonProperty("reply_to_message_id") OptionalLong replyToMessageId,
        @JsonProperty("allow_sending_without_reply") Optional<Boolean> allowSendingWithoutReply,
        @JsonProperty("reply_markup") Optional<ReplyMarkup> replyMarkup
) {
}
