package dev.tobee.telegram.model.chat;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.tobee.telegram.model.message.Message;

public record Chat(
        @JsonProperty("id") Integer id,
        @JsonProperty("type") ChatType type,
        @JsonProperty("title") Optional<String> title,
        @JsonProperty("username") Optional<String> username,
        @JsonProperty("first_name") Optional<String> firstName,
        @JsonProperty("last_name") Optional<String> lastName,
        @JsonProperty("photo") Optional<ChatPhoto> photo,
        @JsonProperty("bio") Optional<String> bio,
        @JsonProperty("has_private_forwards") boolean hasPrivateForwards,
        @JsonProperty("description") Optional<String> description,
        @JsonProperty("invite_link") Optional<String> inviteLink,
        @JsonProperty("pinned_message") Optional<Message> pinnedMessage,
        @JsonProperty("permissions") Optional<ChatPermissions> permissions,
        @JsonProperty("slow_mode_delay") OptionalInt slowModeDelay,
        @JsonProperty("message_auto_delete_time") OptionalInt messageAutoDeleteTime,
        @JsonProperty("has_protected_content") boolean hasProtectedContent,
        @JsonProperty("sticker_set_name") Optional<String> stickerSetName,
        @JsonProperty("can_set_sticker_set") Optional<Boolean> canSetStickerSet,
        @JsonProperty("linked_chat_id") OptionalInt linkedChatId,
        @JsonProperty("location") Optional<ChatLocation> location
) {
}
