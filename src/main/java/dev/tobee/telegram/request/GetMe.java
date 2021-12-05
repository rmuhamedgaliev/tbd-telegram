package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.User;

public class GetMe implements Request<ResponseWrapper<User>> {
    private static final String METHOD = "getMe";
    private static final TypeReference<ResponseWrapper<User>> reference = new TypeReference<>() {};

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<User>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        return Optional.empty();
    }
}
