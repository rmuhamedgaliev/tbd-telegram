package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatMemberStatus {
    CREATOR(Constants.CREATOR),
    ADMINISTRATOR(Constants.ADMINISTRATOR),
    MEMBER(Constants.MEMBER),
    RESTRICTED(Constants.RESTRICTED),
    LEFT(Constants.LEFT),
    KICKED(Constants.KICKED),
    /**/;

    private final String value;

    ChatMemberStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static class Constants {
        public static final String CREATOR = "creator";
        public static final String ADMINISTRATOR = "administrator";
        public static final String MEMBER = "member";
        public static final String RESTRICTED = "restricted";
        public static final String LEFT = "left";
        public static final String KICKED = "kicked";
    }
}
