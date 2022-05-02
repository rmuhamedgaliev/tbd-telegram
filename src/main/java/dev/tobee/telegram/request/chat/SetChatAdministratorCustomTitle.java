package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.SetChatAdministratorCustomTitleBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class SetChatAdministratorCustomTitle implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "setChatAdministratorCustomTitle";
    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {
    };

    private final SetChatAdministratorCustomTitleBody body;

    public SetChatAdministratorCustomTitle(SetChatAdministratorCustomTitleBody body) {
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
