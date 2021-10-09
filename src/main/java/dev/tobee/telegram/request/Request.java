package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;

public interface Request<T> {

    String getMethod();

    TypeReference<T> getResponseType();

    Optional<Map<Object, Object>> getBody();
}
