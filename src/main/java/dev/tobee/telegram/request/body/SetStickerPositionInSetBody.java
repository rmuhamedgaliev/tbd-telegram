package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SetStickerPositionInSetBody(
        @JsonProperty("sticker") String sticker,
        @JsonProperty("position") Integer position
) {
}
