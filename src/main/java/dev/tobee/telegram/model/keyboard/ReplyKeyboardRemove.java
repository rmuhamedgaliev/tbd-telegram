package dev.tobee.telegram.model.keyboard;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record ReplyKeyboardRemove(
        @JsonProperty("remove_keyboard") Boolean removeKeyboard,
        @JsonProperty("selective") Optional<Boolean> selective
) implements ReplyMarkup {
}
