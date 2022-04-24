package dev.tobee.telegram.request.body;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.media.InputFile;

public record SetStickerSetThumbBody(
        @JsonProperty("name") String name,
        @JsonProperty("user_id") long userId,
        @JsonProperty("thumb") Optional<InputFile> thumb
) {
}
