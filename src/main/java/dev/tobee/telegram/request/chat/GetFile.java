package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.media.File;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetFileBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class GetFile implements Request<ResponseWrapper<File>> {
    private static final String METHOD = "getFile";
    private static final TypeReference<ResponseWrapper<File>> reference = new TypeReference<>() {
    };

    private final GetFileBody body;

    public GetFile(GetFileBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<File>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
