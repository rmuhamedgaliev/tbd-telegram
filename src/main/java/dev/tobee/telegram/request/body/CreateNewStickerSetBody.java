package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.InputFile;
import dev.tobee.telegram.model.media.MaskPosition;

import java.util.Optional;

public record CreateNewStickerSetBody(
        @JsonProperty("user_id") long userId,
        @JsonProperty("name") String name,
        @JsonProperty("title") String title,
        @JsonProperty("png_sticker") Optional<InputFile> pngSticker,
        @JsonProperty("tgs_sticker") Optional<InputFile> tgsSticker,
        @JsonProperty("webm_sticker") Optional<InputFile> webmSticker,
        @JsonProperty("emojis") String emojis,
        @JsonProperty("contains_masks") Optional<Boolean> containsMasks,
        @JsonProperty("mask_position") Optional<MaskPosition> maskPosition
) {
}
