package dev.tobee.telegram.request.chat;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.Update;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetUpdateBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class GetUpdates implements Request<ResponseWrapper<List<Update>>> {
    private static final String METHOD = "getUpdates";
    private static final TypeReference<ResponseWrapper<List<Update>>> reference = new TypeReference<>() {};

    private final Optional<GetUpdateBody> queryParams;

    public GetUpdates(Optional<GetUpdateBody> body) {
        this.queryParams = body;
    }

    @Override
    public String getMethod() {
        String method = METHOD;
        Optional<Map<Object, Object>> body = getBody();
        if (body.isPresent()) {
            StringBuilder methodBuilder = new StringBuilder(method + "?");
            for (Map.Entry<Object, Object> entry : body.get().entrySet()) {
                try {
                    methodBuilder
                            .append(URLEncoder.encode((String) entry.getKey(), StandardCharsets.UTF_8.toString())).append("=")
                            .append(URLEncoder.encode("" + entry.getValue(), StandardCharsets.UTF_8.toString())).append("&");
                } catch (Exception e) {
                    throw new IllegalArgumentException("Error on generate query param for request: " + method, e);
                }
            }
            method = methodBuilder.toString();
            method = method.substring(0, method.lastIndexOf('&'));
        }
        return method;
    }

    @Override
    public TypeReference<ResponseWrapper<List<Update>>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        return queryParams.map(DefaultObjectMapper::convertToMap);
    }
}
