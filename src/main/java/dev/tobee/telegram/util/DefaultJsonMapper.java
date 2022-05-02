package dev.tobee.telegram.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;
import java.util.Map;

public class DefaultJsonMapper {

    private static final JsonMapper mapper = JsonMapper.builder()
                                                       .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                                                       .addModule(new Jdk8Module())
                                                       .addModule(new ParameterNamesModule())
                                                       .enable(SerializationFeature.INDENT_OUTPUT)
                                                       .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                                                       .serializationInclusion(JsonInclude.Include.NON_ABSENT)
                                                       .build();

    public static JsonMapper getMapper() {
        return mapper;
    }

    public static <T> String convertToString(T t) {
        try {
            return getMapper().writeValueAsString(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void convertMapValueToStringJson(Map<Object, Object> map, String keyName, T t) {
        map.computeIfPresent(keyName, (key, value) -> convertToString(t));
    }

    public <T> T parseResponse(String response, TypeReference<T> reference) {
        try {
            return mapper.readValue(response, reference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
