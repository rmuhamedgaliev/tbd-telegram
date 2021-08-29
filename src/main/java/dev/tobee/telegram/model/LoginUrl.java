package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record LoginUrl(
        @JsonProperty("url") String url,
        @JsonProperty("forward_text")Optional<String> forwardText,
        @JsonProperty("bot_username") Optional<String> botUsername,
        @JsonProperty("request_write_access") Optional<Boolean> requestWriteAccess
        ) {
}
