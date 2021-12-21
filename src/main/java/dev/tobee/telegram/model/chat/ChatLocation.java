package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.Location;

public record ChatLocation(
        @JsonProperty("location") Location location,
        @JsonProperty("address") String address
) {
}
