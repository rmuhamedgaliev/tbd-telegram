package dev.tobee.telegram.model.poll;

import java.util.List;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.MessageEntity;

public record Poll(
        @JsonProperty("id") String id,
        @JsonProperty("question") String question,
        @JsonProperty("options") List<PollOption> options,
        @JsonProperty("total_voter_count") int totalVoterCount,
        @JsonProperty("is_closed") Boolean isClosed,
        @JsonProperty("is_anonymous") Boolean isAnonymous,
        @JsonProperty("type") PollType type,
        @JsonProperty("allows_multiple_answers") Boolean allowsMultipleAnswers,
        @JsonProperty("correct_option_id") OptionalInt correctOptionId,
        @JsonProperty("explanation") String explanation,
        @JsonProperty("explanation_entities") List<MessageEntity> explanationEntities,
        @JsonProperty("open_period") OptionalInt openPeriod,
        @JsonProperty("close_date") OptionalInt closeDate
) {
}
