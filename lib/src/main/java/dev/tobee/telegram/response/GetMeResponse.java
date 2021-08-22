package dev.tobee.telegram.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Optional;

@JsonSerialize
public record GetMeResponse(
        String id,
        @JsonProperty("is_bot") boolean isBot,
        @JsonProperty("first_name") Optional<String> firstName,
        @JsonProperty("last_name") Optional<String> lastName,
        @JsonProperty("username") Optional<String> username,
        @JsonProperty("language_code") Optional<String> languageCode,
        @JsonProperty("can_join_groups") boolean canJoinGroups,
        @JsonProperty("can_read_all_group_messages") boolean canReadAllGroupMessages,
        @JsonProperty("supports_inline_queries") boolean supportsInlineQueries) {
}
