package dev.tobee.telegram.model;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Message(
        @JsonProperty("message_id") OptionalLong messageId,
        @JsonProperty("from") Optional<User> user,
        @JsonProperty("sender_chat") Optional<Chat> senderChat,
        @JsonProperty("date") long date,
        @JsonProperty("chat") Chat chat,
        @JsonProperty("forward_from") Optional<User> forwardFrom,
        @JsonProperty("forward_from_chat") Optional<Chat> forwardFromChat,
        @JsonProperty("forward_from_message_id") OptionalInt forwardFromMessageId,
        @JsonProperty("forward_signature") Optional<String> forwardSignature,
        @JsonProperty("forward_sender_name") Optional<String> forwardSenderName,
        @JsonProperty("forward_date") OptionalInt forwardDate,
        @JsonProperty("is_automatic_forward") boolean isAutomaticForward,
        @JsonProperty("reply_to_message") Optional<Message> replyToMessage,
        @JsonProperty("via_bot") Optional<User> viaBot,
        @JsonProperty("edit_date") OptionalInt editDate,
        @JsonProperty("has_protected_content") boolean hasProtectedContent,
        @JsonProperty("media_group_id") Optional<String> mediaGroupId,
        @JsonProperty("author_signature") Optional<String> authorSignature,
        @JsonProperty("text") Optional<String> text,
        @JsonProperty("entities") Optional<List<MessageEntity>> entities,
        @JsonProperty("animation") Optional<Animation> animation,
        @JsonProperty("audio") Optional<Audio> audio,
        @JsonProperty("document") Optional<Document> document,
        @JsonProperty("photo") Optional<List<PhotoSize>> photo,
        @JsonProperty("sticker") Optional<Sticker> sticker,
        @JsonProperty("video") Optional<Video> video,
        @JsonProperty("video_note") Optional<VideoNote> video_note,
        @JsonProperty("voice") Optional<Voice> voice,
        @JsonProperty("caption") Optional<String> caption,
        @JsonProperty("caption_entities") Optional<List<MessageEntity>> captionEntities,
        @JsonProperty("contact") Optional<Contact> contact,
        @JsonProperty("dice") Optional<Dice> dice,
        @JsonProperty("game") Optional<Game> game,
        @JsonProperty("poll") Optional<Poll> poll,
        @JsonProperty("location") Optional<Location> location,
        @JsonProperty("new_chat_members") Optional<List<User>> newChatMembers,
        @JsonProperty("left_chat_member") Optional<User> leftChatMember,
        @JsonProperty("new_chat_title") Optional<String> newChatTitle,
        @JsonProperty("new_chat_photo") Optional<List<PhotoSize>> newChatPhoto,
        @JsonProperty("delete_chat_photo") Optional<Boolean> deleteChatPhoto,
        @JsonProperty("group_chat_created") Optional<Boolean> groupChatCreated,
        @JsonProperty("supergroup_chat_created") Optional<Boolean> supergroupChatCreated,
        @JsonProperty("message_auto_delete_timer_changed") Optional<MessageAutoDeleteTimerChanged> messageAutoDeleteTimerChanged,
        @JsonProperty("migrate_to_chat_id") OptionalInt migrateToChatId,
        @JsonProperty("migrate_from_chat_id") OptionalInt migrateFromChatId,
        @JsonProperty("pinned_message") Optional<Message> pinnedMessage,
        @JsonProperty("invoice") Optional<Invoice> invoice,
        @JsonProperty("successful_payment") Optional<SuccessfulPayment> successfulPayment,
        @JsonProperty("connected_website") Optional<String> connectedWebsite,
        @JsonProperty("passport_data") Optional<PassportData> passportData,
        @JsonProperty("proximity_alert_triggered") Optional<ProximityAlertTriggered> proximityAlertTriggered,
        @JsonProperty("voice_chat_scheduled") Optional<VoiceChatScheduled> voiceChatScheduled,
        @JsonProperty("voice_chat_started") Optional<VoiceChatStarted> voiceChatStarted,
        @JsonProperty("voice_chat_ended") Optional<VoiceChatEnded> voiceChatEnded,
        @JsonProperty("voice_chat_participants_invited") Optional<VoiceChatParticipantsInvited> voiceChatParticipantsInvited,
        @JsonProperty("reply_markup") Optional<InlineKeyboardMarkup> replyMarkup

) {
}
