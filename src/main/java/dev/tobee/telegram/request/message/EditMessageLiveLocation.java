package dev.tobee.telegram.request.message;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.EditMessageLiveLocationBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class EditMessageLiveLocation implements Request<ResponseWrapper<Message>> {

    private static final String METHOD = "editMessageLiveLocation";
    private static final TypeReference<ResponseWrapper<Message>> reference = new TypeReference<>() {
    };
    private final EditMessageLiveLocationBody body;

    public EditMessageLiveLocation(EditMessageLiveLocationBody body) {
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
