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
import dev.tobee.telegram.model.media.InputFile;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendDocumentBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendDocumentTest {

    @Test
    void checkValidRequest() throws IOException {
        Path path = new File("data/1x1.png").toPath();

        var inputFile = new InputFile(
                path.getFileName().toString(),
                Files.probeContentType(path),
                new FileInputStream(path.toFile()).readAllBytes()
        );

        SendDocument sendAnimation = new SendDocument(
                new SendDocumentBody(159L, inputFile, Optional.empty(),
                        Optional.empty(), Optional.empty(), List.of(),
                        Optional.empty(), Optional.empty(), Optional.empty(), OptionalInt.empty(), Optional.empty(),
                        Optional.empty())
        );

        Assertions.assertEquals(sendAnimation.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendDocument", sendAnimation.getMethod());
        Assertions.assertTrue(sendAnimation.getBody().isPresent());
    }
}
