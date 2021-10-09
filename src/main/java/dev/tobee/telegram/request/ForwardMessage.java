package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.Message;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.ForwardMessageBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class ForwardMessage implements Request<ResponseWrapper<Message>> {
    private static final String METHOD = "forwardMessage";
    private static final TypeReference<ResponseWrapper<Message>> reference = new TypeReference<>() {
    };
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final ForwardMessageBody body;

    public ForwardMessage(ForwardMessageBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<Message>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        return Optional.of(mapper.convertToMap(body));
    }
}
