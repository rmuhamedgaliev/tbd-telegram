package dev.tobee.telegram.model.media;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Venue(
        @JsonProperty("location") Location location,
        @JsonProperty("title") String title,
        @JsonProperty("address") String address,
        @JsonProperty("foursquare_id") Optional<String> foursquareId,
        @JsonProperty("foursquare_type") Optional<String> foursquareType,
        @JsonProperty("google_place_id") Optional<String> googlePlaceId,
        @JsonProperty("google_place_type") Optional<String> googlePlaceType
) {
}
