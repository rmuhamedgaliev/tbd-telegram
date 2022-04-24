package dev.tobee.telegram.request.sticker;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.media.StickerSet;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.GetStickerSetBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

public class GetStickerSet implements Request<ResponseWrapper<StickerSet>> {

    private static final String METHOD = "getStickerSet";

    private static final TypeReference<ResponseWrapper<StickerSet>> reference = new TypeReference<>() {
    };

    private final GetStickerSetBody body;

    public GetStickerSet(GetStickerSetBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<StickerSet>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }

}
