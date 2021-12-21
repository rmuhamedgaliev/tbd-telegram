package dev.tobee.telegram.request.sendobject;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.SendVideoNoteBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class SendVideoNote implements Request<ResponseWrapper<Message>> {
    private static final String METHOD = "sendVideoNote";
    private static final TypeReference<ResponseWrapper<Message>> reference = new TypeReference<>() {
    };
    private final SendVideoNoteBody body;

    public SendVideoNote(SendVideoNoteBody body) {
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
