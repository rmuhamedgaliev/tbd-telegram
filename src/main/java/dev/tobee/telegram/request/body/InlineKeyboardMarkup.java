package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record InlineKeyboardMarkup(
        @JsonProperty("inline_keyboard") List<List<InlineKeyboardButton>> inlineKeyboard
) implements ReplyMarkup {
}
