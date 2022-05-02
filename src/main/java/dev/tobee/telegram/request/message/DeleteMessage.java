package dev.tobee.telegram.request.message;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.DeleteMessageBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class DeleteMessage implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "deleteMessage";
    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {
    };
    private final DeleteMessageBody body;

    public DeleteMessage(DeleteMessageBody body) {
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
