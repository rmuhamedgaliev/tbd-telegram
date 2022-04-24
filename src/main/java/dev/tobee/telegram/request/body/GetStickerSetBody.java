package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetStickerSetBody(
        @JsonProperty("name") String name
) {
}
