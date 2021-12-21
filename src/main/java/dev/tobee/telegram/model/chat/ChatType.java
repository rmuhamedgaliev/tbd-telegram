package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChatType {
    @JsonProperty("private")
    PRIVATE,
    @JsonProperty("group")
    GROUP,
    @JsonProperty("supergroup")
    SUPERGROUP,
    @JsonProperty("channel")
    CHANNEL
}
