package dev.tobee.telegram.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UpdateTypes {
    @JsonProperty("message")
    MESSAGE,
    @JsonProperty("edited_message")
    EDITED_MESSAGE,
    @JsonProperty("channel_post")
    CHANNEL_POST,
    @JsonProperty("edited_channel_post")
    EDITED_CHANNEL_POST,
    @JsonProperty("chosen_inline_result")
    CHOSEN_INLINE_RESULT,
    @JsonProperty("callback_query")
    CALLBACK_QUERY,
    @JsonProperty("shipping_query")
    SHIPPING_QUERY,
    @JsonProperty("pre_checkout_query")
    PRE_CHECKOUT_QUERY,
    @JsonProperty("poll")
    POLL,
    @JsonProperty("poll_answer")
    POLL_ANSWER,
    @JsonProperty("my_chat_member")
    MY_CHAT_MEMBER,
    @JsonProperty("chat_member")
    CHAT_MEMBER,
    @JsonProperty("chat_join_request")
    CHAT_JOIN_REQUEST,
    /**/
}
