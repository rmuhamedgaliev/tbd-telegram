package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PassportData(
        @JsonProperty("data") List<EncryptedPassportElement> data,
        @JsonProperty("credentials") EncryptedCredentials credentials
) {
}
