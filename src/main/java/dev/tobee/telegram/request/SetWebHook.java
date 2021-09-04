package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetWebHookBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class SetWebHook implements Request<ResponseWrapper<Boolean>> {

    private static final String METHOD = "setWebhook";

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {};

    private final SetWebHookBody body;

    public SetWebHook(SetWebHookBody body) {
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
        return Optional.ofNullable(mapper.convertToMap(body));
    }
}
