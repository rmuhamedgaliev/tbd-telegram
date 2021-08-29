package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;
import java.util.OptionalInt;

public record Contact(
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") Optional<String> lastName,
        @JsonProperty("user_id") OptionalInt userId,
        @JsonProperty("vcard") Optional<String> vcard
) {
}
