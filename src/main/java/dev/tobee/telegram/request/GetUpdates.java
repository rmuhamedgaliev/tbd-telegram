package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.response.ResponseWrapper;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GetUpdates implements Request<ResponseWrapper<List<Map<String, Object>>>>{

    private static final String METHOD = "/getUpdates";

    private static final TypeReference<ResponseWrapper<List<Map<String, Object>>>> reference =
            new TypeReference<>() {};

    private final String host;

    private final String token;

    public GetUpdates(String host, String token) {
        this.host = host;
        this.token = token;
    }

    @Override
    public URI getUri() {
        return URI.create(host + "/" + token + METHOD);
    }

    @Override
    public TypeReference<ResponseWrapper<List<Map<String, Object>>>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> body() {
        return Optional.empty();
    }
}
