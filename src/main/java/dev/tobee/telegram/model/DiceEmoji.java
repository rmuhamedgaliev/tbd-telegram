package dev.tobee.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DiceEmoji {
    @JsonProperty("🎲")
    GAME_DIE("🎲"),
    @JsonProperty("🎯")
    DIRECT_HIT("🎯"),
    @JsonProperty("🏀")
    BASKETBALL("🏀"),
    @JsonProperty("⚽")
    SOCCER_BALL("⚽"),
    @JsonProperty("🎳")
    BOWLING("🎳");

    public final String emoji;

    DiceEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}
