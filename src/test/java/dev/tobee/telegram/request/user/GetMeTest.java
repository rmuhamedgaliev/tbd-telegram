package dev.tobee.telegram.request.user;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.model.message.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetMeTest {

    @Test
    void checkValidRequest() {
        GetMe getMe = new GetMe();

        Assertions.assertEquals(getMe.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<User>>() {}).getType().getTypeName());
        Assertions.assertEquals("getMe", getMe.getMethod());
        Assertions.assertTrue(getMe.getBody().isEmpty());
    }
}
