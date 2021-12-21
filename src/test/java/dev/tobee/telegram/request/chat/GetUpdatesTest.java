package dev.tobee.telegram.request.chat;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.model.message.Update;
import dev.tobee.telegram.request.body.GetUpdateBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetUpdatesTest {

    @Test
    void checkValidRequest() {
        GetUpdates getUpdates = new GetUpdates(
                Optional.of(
                        new GetUpdateBody(
                                OptionalLong.empty(),
                                OptionalInt.empty(),
                                OptionalInt.empty(),
                                Collections.emptyList()
                        )
                )
        );

        Assertions.assertEquals(getUpdates.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<List<Update>>>() {}).getType().getTypeName());
        Assertions.assertTrue(getUpdates.getMethod().contains("getUpdates"));
        Assertions.assertTrue(getUpdates.getBody().isPresent());
    }

    @Test
    void checkValidMethodUrl() {
        GetUpdates getUpdates = new GetUpdates(Optional.empty());

        Assertions.assertEquals("getUpdates", getUpdates.getMethod());
    }
}
