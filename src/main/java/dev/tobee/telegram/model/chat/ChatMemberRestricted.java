package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record ChatMemberRestricted(
        @JsonProperty("status") ChatMemberStatus status,
        @JsonProperty("user") User user,
        @JsonProperty("is_member") boolean isMember,
        @JsonProperty("can_change_info") boolean canChangeInfo,
        @JsonProperty("can_invite_users") boolean canInviteUsers,
        @JsonProperty("can_pin_messages") boolean canPinMessages,
        @JsonProperty("can_send_messages") boolean canSendMessages,
        @JsonProperty("can_send_media_messages") boolean canSendMediaMessages,
        @JsonProperty("can_send_polls") boolean canSendPolls,
        @JsonProperty("can_send_other_messages") boolean canSendOtherMessages,
        @JsonProperty("can_add_web_page_previews") boolean canAddWebPagePreviews,
        @JsonProperty("until_date") long untilDate
) implements ChatMember {

    @Override
    public ChatMemberStatus status() {
        return status;
    }
}
