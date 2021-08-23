package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public record ReplyKeyboardMarkup(
        @JsonProperty("keyboard") List<List<KeyboardButton>> keyboard,
        @JsonProperty("resize_keyboard") Optional<Boolean> resizeKeyboard,
        @JsonProperty("one_time_keyboard") Optional<Boolean> oneTimeKeyboard,
        @JsonProperty("input_field_placeholder") Optional<String> inputFieldPlaceholder,
        @JsonProperty("selective") Optional<Boolean> selective
        ) implements ReplyMarkup {
}
