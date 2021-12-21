package dev.tobee.telegram.request.user;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;

public class LogOut implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "logOut";

    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {
    };

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
        return Optional.empty();
    }
}
