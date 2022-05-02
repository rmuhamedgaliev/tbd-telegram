package dev.tobee.telegram.request.comands;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.SetMyCommandsBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class SetMyCommands implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "setMyCommands";
    private final SetMyCommandsBody body;

    public SetMyCommands(SetMyCommandsBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<Boolean>> getResponseType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        DefaultJsonMapper.convertMapValueToStringJson(bodyMap, "commands", body.commands());
        DefaultJsonMapper.convertMapValueToStringJson(bodyMap, "scope", body.scope());
        return Optional.of(bodyMap);
    }
}
