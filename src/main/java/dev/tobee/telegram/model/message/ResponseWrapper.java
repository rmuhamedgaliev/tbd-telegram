package dev.tobee.telegram.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Optional;

/**
 * @param ok          boolean value is successes response
 * @param result      optional of response object with generic type
 * @param errorCode   code of error
 * @param description description of error
 * @param <T>         generic of response type classes in {@link dev.tobee.telegram.model}
 * @author <a href="mailto:rinat.muhamedgaliev@gmail.com">Rinat Muhamedgaliev</a>
 * <p>
 * Http response wrapper with meta fields
 */
@JsonSerialize
public record ResponseWrapper<T>(
        @JsonProperty("ok") boolean ok,
        @JsonProperty("result") Optional<T> result,
        @JsonProperty("error_code") Optional<String> errorCode,
        @JsonProperty("description") Optional<String> description
) {
}
