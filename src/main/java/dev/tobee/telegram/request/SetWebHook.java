package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.SetWebHookBody;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

public class SetWebHook extends BaseRequest implements Request<ResponseWrapper<String>> {

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private static final TypeReference<ResponseWrapper<String>> reference = new TypeReference<>() {};

    private final SetWebHookBody body;

    public SetWebHook(String host, String token, SetWebHookBody body) {
        super("setWebhook", host, token);
        this.body = body;
    }

    @Override
    public URI getUri() {
        return super.buildUri();
    }

    @Override
    public TypeReference<ResponseWrapper<String>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> body() {
        return Optional.ofNullable(mapper.convertToMap(body));
    }
}
