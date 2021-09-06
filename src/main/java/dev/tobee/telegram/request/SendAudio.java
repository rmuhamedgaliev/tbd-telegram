package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.Message;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SendVideoBody;
import dev.tobee.telegram.util.DefaultJsonMapper;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.net.URI;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

public class SendAudio implements Request<ResponseWrapper<Message>> {

    private static final String METHOD = "sendAudio";

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final DefaultJsonMapper jsonMapper = new DefaultJsonMapper();

    private static final TypeReference<ResponseWrapper<Message>> reference = new TypeReference<>() {
    };

    private final SendVideoBody body;

    public SendAudio(SendVideoBody body) {
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

        String photoFieldName = "video";

        if (bodyMap.containsKey(photoFieldName) && bodyMap.get(photoFieldName) instanceof String) {
            bodyMap.put(photoFieldName, Paths.get(URI.create(String.valueOf(bodyMap.get(photoFieldName)))));
        }

        String replyMarkupFieldName = "reply_markup";

        if (bodyMap.containsKey(replyMarkupFieldName)) {
            bodyMap.put(replyMarkupFieldName, jsonMapper.convertToString(body.replyMarkup()));
        }

        return Optional.of(bodyMap);
    }
}
