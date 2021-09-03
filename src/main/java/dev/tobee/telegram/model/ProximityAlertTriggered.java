package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProximityAlertTriggered(
        @JsonProperty("traveler") User traveler,
        @JsonProperty("watcher") User watcher,
        @JsonProperty("distance") User distance
) {
}
