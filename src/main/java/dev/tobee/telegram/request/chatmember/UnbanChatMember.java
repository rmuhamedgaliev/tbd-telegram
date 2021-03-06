package dev.tobee.telegram.request.chatmember;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.UnbanChatMemberBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class UnbanChatMember implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "unbanChatMember";
    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {
    };

    private final UnbanChatMemberBody body;

    public UnbanChatMember(UnbanChatMemberBody body) {
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
