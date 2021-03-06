package dev.tobee.telegram.request.invitelink;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatInviteLink;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.RevokeChatInviteLinkBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class RevokeChatInviteLink implements Request<ResponseWrapper<ChatInviteLink>> {
    private static final String METHOD = "revokeChatInviteLink";
    private static final TypeReference<ResponseWrapper<ChatInviteLink>> reference = new TypeReference<>() {
    };

    private final RevokeChatInviteLinkBody body;

    public RevokeChatInviteLink(RevokeChatInviteLinkBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<ChatInviteLink>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
