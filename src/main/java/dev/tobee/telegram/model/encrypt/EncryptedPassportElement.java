package dev.tobee.telegram.model.encrypt;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.PassportFile;

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
