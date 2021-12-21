package dev.tobee.telegram.request.sendobject;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.SendAudioBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class SendAudio implements Request<ResponseWrapper<Message>> {
    private static final String METHOD = "sendAudio";
    private static final TypeReference<ResponseWrapper<Message>> reference = new TypeReference<>() {
    };
    private final SendAudioBody body;

    public SendAudio(SendAudioBody body) {
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
