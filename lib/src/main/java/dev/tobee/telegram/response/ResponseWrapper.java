package dev.tobee.telegram.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Optional;

@JsonSerialize
public record ResponseWrapper<T>(
        @JsonProperty("ok") boolean ok,
        @JsonProperty("result") Optional<T> result,
        @JsonProperty("error_code") Optional<String> errorCode,
        @JsonProperty("description") Optional<String> description
) {
}
