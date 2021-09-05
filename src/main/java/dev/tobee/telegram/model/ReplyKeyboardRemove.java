package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record ReplyKeyboardRemove(
        @JsonProperty("remove_keyboard") Boolean removeKeyboard,
        @JsonProperty("selective") Optional<Boolean> selective
) implements ReplyMarkup {
}
