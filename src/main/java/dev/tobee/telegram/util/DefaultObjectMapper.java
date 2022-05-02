package dev.tobee.telegram.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.util.Map;

public class DefaultObjectMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new ParameterNamesModule());
        mapper.registerModule(new JavaTimeModule());
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
    }

    private DefaultObjectMapper() {
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static <T> Map<Object, Object> convertToMap(T t) {
        TypeReference<Map<Object, Object>> reference = new TypeReference<>() {
        };
        return mapper.convertValue(t, reference);
    }
}
