package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShippingAddress(
        @JsonProperty("country_code") String countryCode,
        @JsonProperty("state") String state,
        @JsonProperty("city") String city,
        @JsonProperty("street_line1") String streetLine1,
        @JsonProperty("street_line2") String streetLine2,
        @JsonProperty("post_code") String postCode
) {
}
