package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.ShippingAddress;

import java.util.Optional;

public record OrderInfo(
        @JsonProperty("name") Optional<String> name,
        @JsonProperty("phone_number") Optional<String> phone_number,
        @JsonProperty("email") Optional<String> email,
        @JsonProperty("shipping_address") Optional<ShippingAddress> shippingAddress
) {
}
