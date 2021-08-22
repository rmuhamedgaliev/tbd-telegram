package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

public interface Request<T> {

    URI getUri();

    TypeReference<T> getResponseType();

    Optional<Map<Object, Object>> body();
}
