package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.request.body.SendPhotoBody;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.SendPhotoResponse;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.net.URI;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

public class SendPhoto implements Request<ResponseWrapper<SendPhotoResponse>> {

    private static final String METHOD = "sendPhoto";

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private static final TypeReference<ResponseWrapper<SendPhotoResponse>> reference = new TypeReference<>() {};

    private final SendPhotoBody body;

    public SendPhoto(SendPhotoBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<SendPhotoResponse>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {

        Map<Object, Object> requestMap = mapper.convertToMap(body);

        if (requestMap.containsKey("photo") && requestMap.get("photo") instanceof String) {
            requestMap.put("photo", Paths.get(URI.create(String.valueOf(requestMap.get("photo")))));
        }

        return Optional.of(requestMap);
    }
}
