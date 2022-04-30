package dev.tobee.telegram.model.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WebAppInfo(
        @JsonProperty("url") String url
) {
}
