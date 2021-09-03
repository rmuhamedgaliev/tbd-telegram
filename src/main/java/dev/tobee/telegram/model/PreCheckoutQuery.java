package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record PreCheckoutQuery(
        @JsonProperty("id") String id,
        @JsonProperty("from") User from,
        @JsonProperty("currency") String currency,
        @JsonProperty("total_amount") int totalAmount,
        @JsonProperty("invoice_payload") String invoicePayload,
        @JsonProperty("shipping_option_id") Optional<String> shippingOptionId,
        @JsonProperty("order_info") Optional<OrderInfo> orderInfo
) {
}
