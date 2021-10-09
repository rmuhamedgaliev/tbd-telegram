package dev.tobee.telegram.request.body;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AnswerCallbackQueryBody(
        @JsonProperty("callback_query_id") String callbackQueryId,
        @JsonProperty("text") Optional<String> text,
        @JsonProperty("show_alert") Optional<Boolean> showAlert,
        @JsonProperty("url") Optional<String> url,
        @JsonProperty("cache_time") OptionalLong cacheTime
) {
}
