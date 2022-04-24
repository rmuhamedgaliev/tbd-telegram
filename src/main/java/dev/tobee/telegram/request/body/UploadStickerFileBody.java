package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.InputFile;

public record UploadStickerFileBody(
        @JsonProperty("user_id") long userId,
        @JsonProperty("png_sticker") InputFile pngSticker
) {
}
