package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.response.GetMeResponse;
import dev.tobee.telegram.response.ResponseWrapper;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

public class GetMe extends BaseRequest implements Request<ResponseWrapper<GetMeResponse>> {

    private static final TypeReference<ResponseWrapper<GetMeResponse>> reference = new TypeReference<>() {};

    public GetMe(String host, String token) {
        super("getMe", host, token);
    }

    @Override
    public URI getUri() {
        return super.buildUri();
    }

    @Override
    public TypeReference<ResponseWrapper<GetMeResponse>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> body() {
        return Optional.empty();
    }
}
