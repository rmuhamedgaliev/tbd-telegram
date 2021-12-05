package dev.tobee.telegram.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SetChatStickerSetBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetChatStickerSetTest {

    @Test
    void checkValidRequest() {
        SetChatStickerSet setChatStickerSet = new SetChatStickerSet(
                new SetChatStickerSetBody(159L, "sticker")
        );

        Assertions.assertEquals(setChatStickerSet.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("setChatStickerSet", setChatStickerSet.getMethod());
        Assertions.assertTrue(setChatStickerSet.getBody().isPresent());
    }
}
