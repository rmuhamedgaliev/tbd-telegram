package dev.tobee.telegram.request.message;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.MessageId;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.CopyMessageBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class CopyMessage implements Request<ResponseWrapper<MessageId>> {
    private static final String METHOD = "copyMessage";
    private static final TypeReference<ResponseWrapper<MessageId>> reference = new TypeReference<>() {
    };

    private final CopyMessageBody body;

    public CopyMessage(CopyMessageBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<MessageId>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        return Optional.of(DefaultObjectMapper.convertToMap(body));
    }
}
