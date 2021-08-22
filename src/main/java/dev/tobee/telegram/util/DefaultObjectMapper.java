package dev.tobee.telegram.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.util.Map;

public class DefaultObjectMapper {

    private final ObjectMapper mapper;

    public DefaultObjectMapper() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new Jdk8Module());
        this.mapper.registerModule(new ParameterNamesModule());
        this.mapper.registerModule(new JavaTimeModule());
    }

    public <T> Map<Object, Object> convertToMap(T t) {

        TypeReference<Map<Object, Object>> reference = new TypeReference<>() {};

        return mapper.convertValue(t, reference);
    }
}