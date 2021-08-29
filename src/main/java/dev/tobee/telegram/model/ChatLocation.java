package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatLocation(
        @JsonProperty("location") Location location,
        @JsonProperty("address") String address
) {
}
