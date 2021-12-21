package dev.tobee.telegram.model.media;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.encrypt.EncryptedCredentials;
import dev.tobee.telegram.model.encrypt.EncryptedPassportElement;

public record PassportData(
        @JsonProperty("data") List<EncryptedPassportElement> data,
        @JsonProperty("credentials") EncryptedCredentials credentials
) {
}
