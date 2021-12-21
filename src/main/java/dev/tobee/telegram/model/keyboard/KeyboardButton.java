package dev.tobee.telegram.model.keyboard;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KeyboardButton(
        @JsonProperty("text") String text,
        @JsonProperty("request_contact") Optional<Boolean> requestContact,
        @JsonProperty("request_location") Optional<Boolean> requestLocation,
        @JsonProperty("request_poll") Optional<KeyboardButtonPollType> requestPoll
) {
}
