package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record ShippingQuery(
        @JsonProperty("id") String id,
        @JsonProperty("from") User from,
        @JsonProperty("invoice_payload") String invoicePayload,
        @JsonProperty("shipping_address") ShippingAddress shippingAddress
) {
}
