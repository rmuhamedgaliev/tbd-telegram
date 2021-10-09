package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.UserProfilePhotos;
import dev.tobee.telegram.request.body.GetUserProfilePhotosBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class GetUserProfilePhotos implements Request<ResponseWrapper<UserProfilePhotos>> {

    private static final String METHOD = "sendLocation";
    private static final TypeReference<ResponseWrapper<UserProfilePhotos>> reference = new TypeReference<>() {
    };
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final GetUserProfilePhotosBody body;

    public GetUserProfilePhotos(GetUserProfilePhotosBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<UserProfilePhotos>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = mapper.convertToMap(body);

        return Optional.of(bodyMap);
    }
}
