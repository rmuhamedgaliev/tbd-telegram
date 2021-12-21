package dev.tobee.telegram.request.comands;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.bot.BotCommand;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetMyCommandsBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class GetMyCommands implements Request<ResponseWrapper<List<BotCommand>>> {
    private static final String METHOD = "getMyCommands";
    private final GetMyCommandsBody body;

    public GetMyCommands(GetMyCommandsBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<List<BotCommand>>> getResponseType() {
        return new TypeReference<>() {
        };
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        DefaultJsonMapper.convertMapValueToStringJson(bodyMap, "scope", body.scope());
        return Optional.of(bodyMap);
    }
}
