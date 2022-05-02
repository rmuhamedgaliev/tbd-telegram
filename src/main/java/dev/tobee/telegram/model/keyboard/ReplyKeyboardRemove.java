package dev.tobee.telegram.model.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

import java.util.Optional;

public record ReplyKeyboardRemove(
        @JsonProperty("remove_keyboard") Boolean removeKeyboard,
        @JsonProperty("selective") Optional<Boolean> selective
) implements ReplyMarkup {
}
