package dev.tobee.telegram.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.chat.ChatJoinRequest;
import dev.tobee.telegram.model.chat.ChatMemberUpdated;
import dev.tobee.telegram.model.media.PreCheckoutQuery;
import dev.tobee.telegram.model.media.ShippingQuery;
import dev.tobee.telegram.model.poll.Poll;
import dev.tobee.telegram.model.poll.PollAnswer;

import java.util.Optional;

public record Update(
        @JsonProperty("update_id") long updateId,
        @JsonProperty("message") Optional<Message> message,
        @JsonProperty("edited_message") Optional<Message> editedMessage,
        @JsonProperty("channel_post") Optional<Message> channelPost,
        @JsonProperty("edited_channel_post") Optional<Message> editedChannelPost,
        @JsonProperty("inline_query") Optional<InlineQuery> inlineQuery,
        @JsonProperty("chosen_inline_result") Optional<ChosenInlineResult> chosenInlineResult,
        @JsonProperty("callback_query") Optional<CallbackQuery> callbackQuery,
        @JsonProperty("shipping_query") Optional<ShippingQuery> shippingQuery,
        @JsonProperty("pre_checkout_query") Optional<PreCheckoutQuery> preCheckoutQuery,
        @JsonProperty("poll") Optional<Poll> poll,
        @JsonProperty("poll_answer") Optional<PollAnswer> pollAnswer,
        @JsonProperty("my_chat_member") Optional<ChatMemberUpdated> myChatMember,
        @JsonProperty("chat_member") Optional<ChatMemberUpdated> chatMember,
        @JsonProperty("chat_join_request") Optional<ChatJoinRequest> chatJoinRequest
) {

    public boolean isCallBackQuery() {
        return callbackQuery.isPresent();
    }
}
