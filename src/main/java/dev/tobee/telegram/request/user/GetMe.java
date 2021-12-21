package dev.tobee.telegram.request.user;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.model.message.User;
import dev.tobee.telegram.request.Request;

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
