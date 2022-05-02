package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record SuccessfulPayment(
        @JsonProperty("currency") String currency,
        @JsonProperty("total_amount") int totalAmount,
        @JsonProperty("invoice_payload") String invoicePayload,
        @JsonProperty("shipping_option_id") Optional<String> shippingOptionId,
        @JsonProperty("order_info") Optional<OrderInfo> orderInfo,
        @JsonProperty("telegram_payment_charge_id") String telegramPaymentChargeId,
        @JsonProperty("provider_payment_charge_id") String providerPaymentChargeId
) {
}
