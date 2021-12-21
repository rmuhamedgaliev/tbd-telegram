package dev.tobee.telegram.model.message;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record ResponseWrapper<T>(
        @JsonProperty("ok") boolean ok,
        @JsonProperty("result") Optional<T> result,
        @JsonProperty("error_code") Optional<String> errorCode,
        @JsonProperty("description") Optional<String> description
) {
}
