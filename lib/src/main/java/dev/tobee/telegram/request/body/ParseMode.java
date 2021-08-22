package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ParseMode {
    @JsonProperty("Markdown")
    MARKDOWN,
    @JsonProperty("MarkdownV2")
    MARKDOWN_V2,
    @JsonProperty("html")
    HTML
}
