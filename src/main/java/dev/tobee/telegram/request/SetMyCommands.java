package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetMyCommandsBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class SetMyCommands implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "setMyCommands";
    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {
    };
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final DefaultJsonMapper jsonMapper = new DefaultJsonMapper();
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
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = mapper.convertToMap(body);

        String commandsFieldName = "commands";

        if (bodyMap.containsKey(commandsFieldName)) {
            bodyMap.put(commandsFieldName, jsonMapper.convertToString(body.commands()));
        }

        String scopeFieldName = "scope";

        if (bodyMap.containsKey(scopeFieldName)) {
            bodyMap.put(scopeFieldName, jsonMapper.convertToString(body.scope()));
        }

        return Optional.of(bodyMap);
    }
}
