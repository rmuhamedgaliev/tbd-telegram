package dev.tobee.telegram.request.sticker;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.DeleteChatStickerSetBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteChatStickerSetTest {

    @Test
    void checkValidRequest() {
        DeleteChatStickerSet deleteChatStickerSet = new DeleteChatStickerSet(
                new DeleteChatStickerSetBody(159L)
        );

        Assertions.assertEquals(deleteChatStickerSet.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("deleteChatStickerSet", deleteChatStickerSet.getMethod());
        Assertions.assertTrue(deleteChatStickerSet.getBody().isPresent());
    }
}
