package dev.tobee.telegram.model.media;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StickerSet(
        @JsonProperty("name") String name,
        @JsonProperty("title") String title,
        @JsonProperty("is_animated") Boolean isAnimated,
        @JsonProperty("is_video") Boolean isVideo,
        @JsonProperty("contains_masks") Boolean containsMasks,
        @JsonProperty("contains_masks") List<Sticker> stickers,
        @JsonProperty("thumb") Optional<PhotoSize> thumb
) {
}
