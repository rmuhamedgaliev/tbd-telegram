package dev.tobee.telegram.model.keyboard;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.ReplyMarkup;

public record InlineKeyboardMarkup(
        @JsonProperty("inline_keyboard") List<List<InlineKeyboardButton>> inlineKeyboard
) implements ReplyMarkup {
}
