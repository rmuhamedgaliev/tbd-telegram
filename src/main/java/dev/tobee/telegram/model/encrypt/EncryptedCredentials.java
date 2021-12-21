package dev.tobee.telegram.model.encrypt;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EncryptedCredentials(
        @JsonProperty("data") String data,
        @JsonProperty("hash") String hash,
        @JsonProperty("secret") String secret
) {
}
