package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.Message;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SendPollBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class SendPoll implements Request<ResponseWrapper<Message>> {

    private static final String METHOD = "sendPoll";
    private static final TypeReference<ResponseWrapper<Message>> reference = new TypeReference<>() {
    };
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final DefaultJsonMapper jsonMapper = new DefaultJsonMapper();
    private final SendPollBody body;

    public SendPoll(SendPollBody body) {
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
        Map<Object, Object> bodyMap = mapper.convertToMap(body);

        String replyMarkupFieldName = "reply_markup";

        if (bodyMap.containsKey(replyMarkupFieldName)) {
            bodyMap.put(replyMarkupFieldName, jsonMapper.convertToString(body.replyMarkup()));
        }

        return Optional.of(bodyMap);
    }
}
