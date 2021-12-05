package dev.tobee.telegram.request.sendobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.InputFile;
import dev.tobee.telegram.model.Message;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.SendPhotoBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendPhotoTest {

    @Test
    void checkValidRequest() throws IOException {
        Path path = new File("data/1x1.png").toPath();

        var inputFile = new InputFile(
                path.getFileName().toString(),
                Files.probeContentType(path),
                new FileInputStream(path.toFile()).readAllBytes()
        );

        SendPhoto sendPhoto = new SendPhoto(
                new SendPhotoBody(159L, inputFile, Optional.empty(),
                        List.of(), Optional.empty(), OptionalInt.empty(),
                        Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(sendPhoto.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendPhoto", sendPhoto.getMethod());
        Assertions.assertTrue(sendPhoto.getBody().isPresent());
    }
}
