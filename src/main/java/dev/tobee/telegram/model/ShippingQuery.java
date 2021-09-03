package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShippingQuery(
        @JsonProperty("id") String id,
        @JsonProperty("from") User from,
        @JsonProperty("invoice_payload") String invoicePayload,
        @JsonProperty("shipping_address") ShippingAddress shippingAddress
) {
}
