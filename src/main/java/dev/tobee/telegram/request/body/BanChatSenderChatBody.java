package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BanChatSenderChatBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("sender_chat_id") long senderChatId
) {
}
