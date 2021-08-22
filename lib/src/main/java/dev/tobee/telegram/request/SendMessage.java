package dev.tobee.telegram.request;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.response.ResponseWrapper;
import dev.tobee.telegram.response.SendMessageResponse;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

public class SendMessage extends BaseRequest implements Request<ResponseWrapper<SendMessageResponse>> {

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private static final TypeReference<ResponseWrapper<SendMessageResponse>> reference = new TypeReference<>() {};

    private final SendMessageBody body;

    public SendMessage(String host, String token, SendMessageBody body) {
        super("sendMessage", host, token);
        this.body = body;
    }

    @Override
    public URI getUri() {
        return super.buildUri();
    }

    @Override
    public TypeReference<ResponseWrapper<SendMessageResponse>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> body() {
        return Optional.ofNullable(mapper.convertToMap(body));
    }
}
