package dev.tobee.telegram.model.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

import java.util.List;

public record InlineKeyboardMarkup(
        @JsonProperty("inline_keyboard") List<List<InlineKeyboardButton>> inlineKeyboard
) implements ReplyMarkup {
}
