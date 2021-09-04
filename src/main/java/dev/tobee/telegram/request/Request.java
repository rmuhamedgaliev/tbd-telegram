package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;
import java.util.Optional;

public interface Request<T> {

    String getMethod();

    TypeReference<T> getResponseType();

    Optional<Map<Object, Object>> getBody();
}
