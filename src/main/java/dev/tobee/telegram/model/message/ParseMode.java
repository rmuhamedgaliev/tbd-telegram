package dev.tobee.telegram.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ParseMode {
    @JsonProperty("Markdown")
    MARKDOWN,
    @JsonProperty("MarkdownV2")
    MARKDOWN_V2,
    @JsonProperty("html")
    HTML
}
