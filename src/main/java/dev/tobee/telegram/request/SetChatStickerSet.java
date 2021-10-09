package dev.tobee.telegram.request;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetChatStickerSetBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class SetChatStickerSet implements Request<ResponseWrapper<Boolean>> {
    private static final String METHOD = "setChatStickerSet";
    private static final TypeReference<ResponseWrapper<Boolean>> reference = new TypeReference<>() {
    };
    private final DefaultObjectMapper mapper = new DefaultObjectMapper();
    private final SetChatStickerSetBody body;

    public SetChatStickerSet(SetChatStickerSetBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<Boolean>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = mapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
