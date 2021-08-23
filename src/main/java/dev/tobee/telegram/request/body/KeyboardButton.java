package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record KeyboardButton(
        @JsonProperty("text") String text,
        @JsonProperty("request_contact")Optional<Boolean> requestContact,
        @JsonProperty("request_location") Optional<Boolean> requestLocation,
        @JsonProperty("request_poll") Optional<KeyboardButtonPoll> requestPoll
        ) {
}
