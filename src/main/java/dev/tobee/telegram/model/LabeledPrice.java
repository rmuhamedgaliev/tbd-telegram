package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LabeledPrice(
        @JsonProperty("label") String label,
        @JsonProperty("amount") int amount
) {
}
