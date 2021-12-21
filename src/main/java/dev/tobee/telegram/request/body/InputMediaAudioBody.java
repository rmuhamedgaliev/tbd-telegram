package dev.tobee.telegram.request.body;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.MessageEntity;
import dev.tobee.telegram.model.message.ParseMode;

public record InputMediaAudioBody(
        @JsonProperty("type") String type,
        @JsonProperty("media") String media,
        @JsonProperty("thumb") Optional<Path> thumb,
        @JsonProperty("caption") Optional<String> caption,
        @JsonProperty("parse_mode") Optional<ParseMode> parseMode,
        @JsonProperty("caption_entities") List<MessageEntity> entities,
        @JsonProperty("duration") int duration,
        @JsonProperty("performer") Optional<String> performer,
        @JsonProperty("title") Optional<String> title
) {
}
