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

public class DefaultJsonMapper {

    private final JsonMapper mapper;

    public DefaultJsonMapper() {
        this.mapper = JsonMapper.builder()
                .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .addModule(new Jdk8Module().configureAbsentsAsNulls(true))
                .addModule(new ParameterNamesModule())
                .enable(SerializationFeature.INDENT_OUTPUT)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .build();
    }

    public JsonMapper getMapper() {
        return mapper;
    }

    public <T> T parseResponse(String response, TypeReference<T> reference) {
        try {
            return mapper.readValue(response, reference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
