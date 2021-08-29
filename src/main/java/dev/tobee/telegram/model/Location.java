package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record Location(
        @JsonProperty("longitude") float longitude,
        @JsonProperty("latitude") float latitude,
        @JsonProperty("horizontal_accuracy") Optional<Float> horizontalAccuracy,
        @JsonProperty("live_period") Optional<Integer> livePeriod,
        @JsonProperty("heading") Optional<Integer> heading,
        @JsonProperty("proximity_alert_radius") Optional<Integer> proximityAlertRadius
) {
}
