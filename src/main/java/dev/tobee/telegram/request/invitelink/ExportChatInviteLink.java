package dev.tobee.telegram.request.invitelink;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.ExportChatInviteLinkBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class ExportChatInviteLink implements Request<ResponseWrapper<String>> {
    private static final String METHOD = "exportChatInviteLink";
    private static final TypeReference<ResponseWrapper<String>> reference = new TypeReference<>() {
    };

    private final ExportChatInviteLinkBody body;

    public ExportChatInviteLink(ExportChatInviteLinkBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<String>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
