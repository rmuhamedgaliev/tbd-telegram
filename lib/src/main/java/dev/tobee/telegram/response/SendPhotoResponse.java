package dev.tobee.telegram.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record SendPhotoResponse(
        @JsonProperty("message_id") int messageId
) {
}
