package dev.tobee.telegram.request.chatmember;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetChatMemberCountBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class GetChatMemberCount implements Request<ResponseWrapper<Long>> {
    private static final String METHOD = "getChatMemberCount";
    private static final TypeReference<ResponseWrapper<Long>> reference = new TypeReference<>() {
    };

    private final GetChatMemberCountBody body;

    public GetChatMemberCount(GetChatMemberCountBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<Long>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
