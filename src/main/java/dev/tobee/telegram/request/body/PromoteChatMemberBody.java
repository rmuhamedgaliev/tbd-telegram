package dev.tobee.telegram.request.body;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record PromoteChatMemberBody(
        @JsonProperty("chat_id") long chatId,
        @JsonProperty("user_id") long userId,
        @JsonProperty("is_anonymous") Optional<Boolean> is_anonymous,
        @JsonProperty("can_manage_chat") Optional<Boolean> canManageChat,
        @JsonProperty("can_post_messages") Optional<Boolean> canPostMessages,
        @JsonProperty("can_edit_messages") Optional<Boolean> canEditMessages,
        @JsonProperty("can_delete_messages") Optional<Boolean> canDeleteMessages,
        @JsonProperty("can_manage_video_chats") Optional<Boolean> canManageVoiceChats,
        @JsonProperty("can_restrict_members") Optional<Boolean> canRestrictMembers,
        @JsonProperty("can_promote_members") Optional<Boolean> canPromoteMembers,
        @JsonProperty("can_change_info") Optional<Boolean> canChangeInfo,
        @JsonProperty("can_invite_users") Optional<Boolean> canInviteUsers,
        @JsonProperty("can_pin_messages") Optional<Boolean> canPinMessages
) {
}
