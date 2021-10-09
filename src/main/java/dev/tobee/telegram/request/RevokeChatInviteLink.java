package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ChatInviteLink;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.RevokeChatInviteLinkBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class RevokeChatInviteLink implements Request<ResponseWrapper<ChatInviteLink>> {
    private static final String METHOD = "revokeChatInviteLink";
    private static final TypeReference<ResponseWrapper<ChatInviteLink>> reference = new TypeReference<>() {};
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
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
        Map<Object, Object> bodyMap = mapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
