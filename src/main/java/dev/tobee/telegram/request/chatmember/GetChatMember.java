package dev.tobee.telegram.request.chatmember;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatMember;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetChatMemberBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class GetChatMember implements Request<ResponseWrapper<ChatMember>> {
    private static final String METHOD = "getChatMember";
    private static final TypeReference<ResponseWrapper<ChatMember>> reference = new TypeReference<>() {
    };

    private final GetChatMemberBody body;

    public GetChatMember(GetChatMemberBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<ChatMember>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
