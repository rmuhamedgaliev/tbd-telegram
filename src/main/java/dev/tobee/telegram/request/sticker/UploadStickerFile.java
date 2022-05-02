package dev.tobee.telegram.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.media.File;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.body.UploadStickerFileBody;
import dev.tobee.telegram.util.DefaultObjectMapper;

import java.util.Map;
import java.util.Optional;

public class UploadStickerFile implements Request<ResponseWrapper<File>> {

    private static final String METHOD = "uploadStickerFile";

    private static final TypeReference<ResponseWrapper<File>> reference = new TypeReference<>() {
    };

    private final UploadStickerFileBody body;

    public UploadStickerFile(UploadStickerFileBody body) {
        this.body = body;
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    public TypeReference<ResponseWrapper<File>> getResponseType() {
        return reference;
    }

    @Override
    public Optional<Map<Object, Object>> getBody() {
        Map<Object, Object> bodyMap = DefaultObjectMapper.convertToMap(body);
        return Optional.of(bodyMap);
    }
}
