package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.Update;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GetUpdates implements Request<ResponseWrapper<List<Update>>>{

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private static final String METHOD = "/getUpdates";

    private static final TypeReference<ResponseWrapper<List<Update>>> reference =
            new TypeReference<>() {};

    private final String host;

    private final String token;

    private final Optional<GetUpdateBody> body;

    public GetUpdates(String host, String token, Optional<GetUpdateBody> body) {
        this.host = host;
        this.token = token;
        this.body = body;
    }

    @Override
    public URI getUri() {

        String url = host + "/" + token + METHOD;

        if (body().isPresent()) {
            url = url + "?";

            for (Map.Entry<Object, Object> entry: body().get().entrySet()) {
                try {
                    url += URLEncoder.encode((String) entry.getKey(), StandardCharsets.UTF_8.toString()) + "="
                            + URLEncoder.encode("" + entry.getValue(), StandardCharsets.UTF_8.toString()) + "&";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            url = url.substring(0, url.lastIndexOf('&'));
        }


        return URI.create(url);
    }

    @Override
    public TypeReference<ResponseWrapper<List<Update>>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> body() {
        return body.map(mapper::convertToMap);
    }
}
