package dev.tobee.telegram.request;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ChatMember;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.GetChatAdministratorsBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class GetChatAdministrators implements Request<ResponseWrapper<List<ChatMember>>> {
    private static final String METHOD = "getChatAdministrators";
    private static final TypeReference<ResponseWrapper<List<ChatMember>>> reference = new TypeReference<>() {};
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final GetChatAdministratorsBody body;

    public GetChatAdministrators(GetChatAdministratorsBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<List<ChatMember>>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = mapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}