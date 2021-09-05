package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.SendMessageResponse;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class SendMessage implements Request<ResponseWrapper<SendMessageResponse>> {
    private static final String METHOD = "sendMessage";
    private static final TypeReference<ResponseWrapper<SendMessageResponse>> reference = new TypeReference<>() {
    };
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final DefaultJsonMapper jsonMapper = new DefaultJsonMapper();
    private final SendMessageBody body;

    public SendMessage(SendMessageBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<SendMessageResponse>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Optional<Map<Object, Object>> bodyMap = Optional.ofNullable(mapper.convertToMap(body));

        String replyMarkupFieldName = "reply_markup";

        if (bodyMap.isPresent() && bodyMap.get().containsKey(replyMarkupFieldName)) {
            bodyMap.get().put(replyMarkupFieldName, jsonMapper.convertToString(body.replyMarkup()));
        }

        return bodyMap;
    }
}
