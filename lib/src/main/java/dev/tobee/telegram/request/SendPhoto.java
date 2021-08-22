package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.request.body.SendPhotoBody;
import dev.tobee.telegram.response.ResponseWrapper;
import dev.tobee.telegram.response.SendPhotoResponse;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.net.URI;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

public class SendPhoto extends BaseRequest implements Request<ResponseWrapper<SendPhotoResponse>> {

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private static final TypeReference<ResponseWrapper<SendPhotoResponse>> reference = new TypeReference<>() {};

    private final SendPhotoBody body;

    public SendPhoto(String host, String token, SendPhotoBody body) {
        super("sendPhoto", host, token);
        this.body = body;
    }

    @Override
    public URI getUri() {
        return super.buildUri();
    }

    @Override
    public TypeReference<ResponseWrapper<SendPhotoResponse>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> body() {

        Map<Object, Object> requestMap = mapper.convertToMap(body);

        if (requestMap.containsKey("photo") && requestMap.get("photo") instanceof String) {
            requestMap.put("photo", Paths.get(URI.create(String.valueOf(requestMap.get("photo")))));
        }

        return Optional.of(requestMap);
    }
}
