package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetFileBody(
        @JsonProperty("fileId") String fileId
) {
}
