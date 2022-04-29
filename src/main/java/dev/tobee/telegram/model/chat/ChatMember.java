package dev.tobee.telegram.model.chat;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "status",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChatMemberOwner.class, name = ChatMemberStatus.Constants.CREATOR),
        @JsonSubTypes.Type(value = ChatMemberAdministrator.class, name = ChatMemberStatus.Constants.ADMINISTRATOR),
        @JsonSubTypes.Type(value = ChatMemberMember.class, name = ChatMemberStatus.Constants.MEMBER),
        @JsonSubTypes.Type(value = ChatMemberRestricted.class, name = ChatMemberStatus.Constants.RESTRICTED),
        @JsonSubTypes.Type(value = ChatMemberLeft.class, name = ChatMemberStatus.Constants.LEFT),
        @JsonSubTypes.Type(value = ChatMemberBanned.class, name = ChatMemberStatus.Constants.KICKED)
})
public interface ChatMember {
    ChatMemberStatus status();
}
