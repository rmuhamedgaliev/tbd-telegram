package dev.tobee.telegram.model.media;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.MessageEntity;

import java.util.List;
import java.util.Optional;

public record Game(
        @JsonProperty("title") String title,
        @JsonProperty("description") String description,
        @JsonProperty("photo") List<PhotoSize> photo,
        @JsonProperty("text") Optional<String> text,
        @JsonProperty("text_entities") List<MessageEntity> textEntities,
        @JsonProperty("animation") Optional<Animation> animation
) {
}
