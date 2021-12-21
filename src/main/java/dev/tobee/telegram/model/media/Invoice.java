package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Invoice(
        @JsonProperty("title") String title,
        @JsonProperty("description") String description,
        @JsonProperty("start_parameter") String startParameter,
        @JsonProperty("currency") String currency,
        @JsonProperty("total_amount") int totalAmount
) {
}
