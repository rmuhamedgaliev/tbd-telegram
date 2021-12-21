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
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SetWebHookBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetWebHookTest {

    @Test
    void checkValidRequest() throws IOException {
        Path path = new File("data/1x1.png").toPath();

        var inputFile = new InputFile(
                path.getFileName().toString(),
                Files.probeContentType(path),
                new FileInputStream(path.toFile()).readAllBytes()
        );

        SetWebHook setWebHook = new SetWebHook(
                new SetWebHookBody("https://volunteerstamlwm.ar", Optional.empty(), Optional.empty(), OptionalInt.empty(), List.of(), Optional.empty())
        );

        Assertions.assertEquals(setWebHook.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("setWebhook", setWebHook.getMethod());
        Assertions.assertTrue(setWebHook.getBody().isPresent());
    }
}
