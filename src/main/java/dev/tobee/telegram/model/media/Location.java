package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalInt;

public record Location(
        @JsonProperty("longitude") float longitude,
        @JsonProperty("latitude") float latitude,
        @JsonProperty("horizontal_accuracy") Optional<Float> horizontalAccuracy,
        @JsonProperty("live_period") OptionalInt livePeriod,
        @JsonProperty("heading") OptionalInt heading,
        @JsonProperty("proximity_alert_radius") OptionalInt proximityAlertRadius
) {
}
