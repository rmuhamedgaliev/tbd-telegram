package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.SendMessageBody;
import dev.tobee.telegram.model.SendMessageResponse;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class SendMessage implements Request<ResponseWrapper<SendMessageResponse>> {

    private static final String METHOD = "sendMessage";

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private static final TypeReference<ResponseWrapper<SendMessageResponse>> reference = new TypeReference<>() {};

    private final SendMessageBody body;

    public SendMessage(SendMessageBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<SendMessageResponse>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        return Optional.ofNullable(mapper.convertToMap(body));
    }
}
