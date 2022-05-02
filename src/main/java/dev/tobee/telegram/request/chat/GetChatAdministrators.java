package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatMember;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetChatAdministratorsBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GetChatAdministrators implements Request<ResponseWrapper<List<ChatMember>>> {
    private static final String METHOD = "getChatAdministrators";
    private static final TypeReference<ResponseWrapper<List<ChatMember>>> reference = new TypeReference<>() {
    };

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
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
