package dev.tobee.telegram.request.user;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.ResponseWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LogOutTest {

    @Test
    void checkValidRequest() {
        LogOut logOut = new LogOut();

        Assertions.assertEquals(logOut.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("logOut", logOut.getMethod());
        Assertions.assertTrue(logOut.getBody().isEmpty());
    }
}
