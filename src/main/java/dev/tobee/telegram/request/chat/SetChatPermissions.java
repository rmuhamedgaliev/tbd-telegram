package dev.tobee.telegram.request.chat;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.SetChatPermissionsBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class SetChatPermissions implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "setChatPermissions";
    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {};

    private final SetChatPermissionsBody body;

    public SetChatPermissions(SetChatPermissionsBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<Boolean>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
