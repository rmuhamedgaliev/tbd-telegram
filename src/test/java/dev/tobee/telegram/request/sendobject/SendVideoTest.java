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
import dev.tobee.telegram.request.body.SendVideoBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendVideoTest {

    @Test
    void checkValidRequest() throws IOException {
        Path path = new File("data/1x1.png").toPath();

        var inputFile = new InputFile(
                path.getFileName().toString(),
                Files.probeContentType(path),
                new FileInputStream(path.toFile()).readAllBytes()
        );

        SendVideo sendVideo = new SendVideo(
                new SendVideoBody(159L, inputFile, OptionalInt.empty(),
                        OptionalInt.empty(), OptionalInt.empty(), inputFile, Optional.empty(),
                        Optional.empty(), List.of(), Optional.empty(), Optional.empty(), OptionalInt.empty(),
                        Optional.empty(), Optional.empty())
        );

        Assertions.assertEquals(sendVideo.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendVideo", sendVideo.getMethod());
        Assertions.assertTrue(sendVideo.getBody().isPresent());
    }
}
