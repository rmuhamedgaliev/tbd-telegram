package dev.tobee.telegram.model.keyboard;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record ReplyKeyboardMarkup(
        @JsonProperty("keyboard") List<List<KeyboardButton>> keyboard,
        @JsonProperty("resize_keyboard") Optional<Boolean> resizeKeyboard,
        @JsonProperty("one_time_keyboard") Optional<Boolean> oneTimeKeyboard,
        @JsonProperty("input_field_placeholder") Optional<String> inputFieldPlaceholder,
        @JsonProperty("selective") Optional<Boolean> selective
) implements ReplyMarkup {
}
