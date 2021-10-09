package dev.tobee.telegram.request.body;

import java.util.List;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.UpdateTypes;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GetUpdateBody(
        @JsonProperty("offset") OptionalInt offset,
        @JsonProperty("limit") OptionalInt limit,
        @JsonProperty("timeout") OptionalInt timeout,
        @JsonProperty("allowed_updates") List<UpdateTypes> allowedUpdates
) {
}
