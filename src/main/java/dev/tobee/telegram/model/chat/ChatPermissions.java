package dev.tobee.telegram.model.chat;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatPermissions(
        @JsonProperty("can_send_messages") Optional<Boolean> canSendMessages,
        @JsonProperty("can_send_media_messages") Optional<Boolean> canSendMediaMessages,
        @JsonProperty("can_send_polls") Optional<Boolean> canSendPolls,
        @JsonProperty("can_send_other_messages") Optional<Boolean> canSendOtherMessages,
        @JsonProperty("can_add_web_page_previews") Optional<Boolean> canAddWebPagePreviews,
        @JsonProperty("can_change_info") Optional<Boolean> canChangeInfo,
        @JsonProperty("can_invite_users") Optional<Boolean> canInviteUsers,
        @JsonProperty("can_pin_messages") Optional<Boolean> canPinMessages
) {
}
