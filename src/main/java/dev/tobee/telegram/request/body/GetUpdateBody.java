package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.UpdateTypes;

import java.util.List;
import java.util.OptionalInt;
import java.util.OptionalLong;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GetUpdateBody(
        @JsonProperty("offset") OptionalLong offset,
        @JsonProperty("limit") OptionalInt limit,
        @JsonProperty("timeout") OptionalInt timeout,
        @JsonProperty("allowed_updates") List<UpdateTypes> allowedUpdates
) {
}
