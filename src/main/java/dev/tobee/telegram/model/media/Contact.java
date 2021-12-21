package dev.tobee.telegram.model.media;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Contact(
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") Optional<String> lastName,
        @JsonProperty("user_id") OptionalInt userId,
        @JsonProperty("vcard") Optional<String> vcard
) {
}
