package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MaskPosition(
        @JsonProperty("point") String point,
        @JsonProperty("x_shift") float xShift,
        @JsonProperty("y_shift") float yShift,
        @JsonProperty("scale") float scale
) {
}
