package dev.tobee.telegram.request.sticker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.media.InputFile;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendStickerBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendStickerTest {

    @Test
    void checkValidRequest() throws IOException {
        Path path = new File("data/1x1.png").toPath();

        var inputFile = new InputFile(
                path.getFileName().toString(),
                Files.probeContentType(path),
                new FileInputStream(path.toFile()).readAllBytes()
        );

        SendSticker sendSticker = new SendSticker(new SendStickerBody(159L, inputFile, Optional.empty(),
                Optional.empty(), OptionalInt.empty(), Optional.empty(), Optional.empty()));

        Assertions.assertEquals(sendSticker.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendSticker", sendSticker.getMethod());
        Assertions.assertTrue(sendSticker.getBody().isPresent());
    }
}
