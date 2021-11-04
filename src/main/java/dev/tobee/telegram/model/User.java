package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record User(
        @JsonProperty("id") Long id,
        @JsonProperty("is_bot") Boolean isBot,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") Optional<String> lastName,
        @JsonProperty("username") Optional<String> username,
        @JsonProperty("language_code") Optional<String> languageCode,
        @JsonProperty("can_join_groups") Optional<Boolean> canJoinGroups,
        @JsonProperty("can_read_all_group_messages") Optional<Boolean> canReadAllGroupMessages,
        @JsonProperty("supports_inline_queries") Optional<Boolean> supportsInlineQueries
) {
}
