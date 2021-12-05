package dev.tobee.telegram.model;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
        @JsonProperty("longitude") float longitude,
        @JsonProperty("latitude") float latitude,
        @JsonProperty("horizontal_accuracy") Optional<Float> horizontalAccuracy,
        @JsonProperty("live_period") OptionalInt livePeriod,
        @JsonProperty("heading") OptionalInt heading,
        @JsonProperty("proximity_alert_radius") OptionalInt proximityAlertRadius
) {
}
