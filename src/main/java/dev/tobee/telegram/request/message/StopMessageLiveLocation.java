package dev.tobee.telegram.request.message;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.StopMessageLiveLocationBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class StopMessageLiveLocation implements Request<ResponseWrapper<Message>> {
    private static final String METHOD = "stopMessageLiveLocation";
    private static final TypeReference<ResponseWrapper<Message>> reference = new TypeReference<>() {
    };
    private final StopMessageLiveLocationBody body;

    public StopMessageLiveLocation(StopMessageLiveLocationBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<Message>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        DefaultJsonMapper.convertMapValueToStringJson(bodyMap, "reply_markup", body.replyMarkup());
        return Optional.of(bodyMap);
    }
}
