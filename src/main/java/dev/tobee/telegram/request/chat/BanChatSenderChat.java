package dev.tobee.telegram.request.chat;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.BanChatSenderChatBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class BanChatSenderChat implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "banChatSenderChat";
    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {};

    private final BanChatSenderChatBody body;

    public BanChatSenderChat(BanChatSenderChatBody body) {
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
