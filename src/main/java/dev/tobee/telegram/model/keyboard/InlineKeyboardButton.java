package dev.tobee.telegram.model.keyboard;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.LoginUrl;

public record InlineKeyboardButton(
        @JsonProperty("text") String text,
        @JsonProperty("url") Optional<String> url,
        @JsonProperty("login_url") Optional<LoginUrl> loginUrl,
        @JsonProperty("callback_data") Optional<String> callbackData,
        @JsonProperty("switch_inline_query") Optional<String> switchInlineQuery,
        @JsonProperty("switch_inline_query_current_chat") Optional<String> switchInlineQueryCurrentChat,
        @JsonProperty("pay") Optional<Boolean> pay
) {
}
