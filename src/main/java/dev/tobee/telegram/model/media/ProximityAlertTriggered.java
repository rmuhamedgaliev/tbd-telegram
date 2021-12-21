package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record ProximityAlertTriggered(
        @JsonProperty("traveler") User traveler,
        @JsonProperty("watcher") User watcher,
        @JsonProperty("distance") User distance
) {
}
