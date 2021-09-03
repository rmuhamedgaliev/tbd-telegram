package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public record EncryptedPassportElement(
        @JsonProperty("type") EncryptedCredentialsType type,
        @JsonProperty("data") Optional<String> data,
        @JsonProperty("phone_number") Optional<String> phoneNumber,
        @JsonProperty("email") Optional<String> email,
        @JsonProperty("files") List<PassportFile> files,
        @JsonProperty("front_side") Optional<PassportFile> frontSide,
        @JsonProperty("reverse_side") Optional<PassportFile> reverseSide,
        @JsonProperty("selfie") Optional<PassportFile> selfie,
        @JsonProperty("translation") List<PassportFile> translation,
        @JsonProperty("hash") List<String> hash
) {
}
