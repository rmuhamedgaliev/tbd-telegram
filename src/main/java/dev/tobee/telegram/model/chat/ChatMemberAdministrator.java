package dev.tobee.telegram.model.chat;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.User;

public record ChatMemberAdministrator(
        @JsonProperty("status") ChatMemberStatus status,
        @JsonProperty("user") User user,
        @JsonProperty("can_be_edited") boolean canBeEdited,
        @JsonProperty("is_anonymous") boolean isAnonymous,
        @JsonProperty("can_manage_chat") boolean canManageChat,
        @JsonProperty("can_delete_messages") boolean canDeleteMessages,
        @JsonProperty("can_manage_video_chats") boolean canManageVoiceChats,
        @JsonProperty("can_restrict_members") boolean canRestrictMembers,
        @JsonProperty("can_promote_members") boolean canPromoteMembers,
        @JsonProperty("can_change_info") boolean canChangeInfo,
        @JsonProperty("can_invite_users") boolean canInviteUsers,
        @JsonProperty("can_post_messages") boolean canPostMessages,
        @JsonProperty("can_edit_messages") boolean canEditMessages,
        @JsonProperty("can_pin_messages") boolean canPinMessages,
        @JsonProperty("custom_title") Optional<String> customTitle
) implements ChatMember {

    @Override
    public ChatMemberStatus status() {
        return status;
    }
}
