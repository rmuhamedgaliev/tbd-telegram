package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.GetMeResponse;
import dev.tobee.telegram.model.ResponseWrapper;

import java.util.Map;
import java.util.Optional;

public class GetMe implements Request<ResponseWrapper<GetMeResponse>> {

    private static final String METHOD = "getMe";

    private static final TypeReference<ResponseWrapper<GetMeResponse>> reference = new TypeReference<>() {};

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<GetMeResponse>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        return Optional.empty();
    }
}
