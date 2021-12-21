package dev.tobee.telegram.request.chat;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.media.File;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.GetFileBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetFileTest {

    @Test
    void checkValidRequest() {
        GetFile getFile = new GetFile(
                new GetFileBody("b552fc68-a56c-4e47-96e2-af4dbedfb7c9")
        );

        Assertions.assertEquals(getFile.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<File>>() {}).getType().getTypeName());
        Assertions.assertEquals("getFile", getFile.getMethod());
        Assertions.assertTrue(getFile.getBody().isPresent());
    }
}
