package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteStickerFromSetBody(
        @JsonProperty("sticker") String sticker
) {
}
