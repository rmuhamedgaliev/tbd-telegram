package dev.tobee.telegram.model.media;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderInfo(
        @JsonProperty("name") Optional<String> name,
        @JsonProperty("phone_number") Optional<String> phone_number,
        @JsonProperty("email") Optional<String> email,
        @JsonProperty("shipping_address") Optional<ShippingAddress> shippingAddress
) {
}
