package dev.tobee.telegram.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.UpdateTypes;

import java.util.List;
import java.util.OptionalInt;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GetUpdateBody(
        @JsonProperty("offset") OptionalInt offset,
        @JsonProperty("limit") OptionalInt limit,
        @JsonProperty("timeout") OptionalInt timeout,
        @JsonProperty("allowed_updates") List<UpdateTypes> allowedUpdates
) {
}