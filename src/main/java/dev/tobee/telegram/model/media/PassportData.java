package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.encrypt.EncryptedCredentials;
import dev.tobee.telegram.model.encrypt.EncryptedPassportElement;

import java.util.List;

public record PassportData(
        @JsonProperty("data") List<EncryptedPassportElement> data,
        @JsonProperty("credentials") EncryptedCredentials credentials
) {
}
