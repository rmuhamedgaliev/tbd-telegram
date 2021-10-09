package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.Chat;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.GetChatBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class GetChat implements Request<ResponseWrapper<Chat>> {
    private static final String METHOD = "getChat";
    private static final TypeReference<ResponseWrapper<Chat>> reference = new TypeReference<>() {};
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final GetChatBody body;

    public GetChat(GetChatBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<Chat>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = mapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
