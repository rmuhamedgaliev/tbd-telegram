package dev.tobee.telegram;

import dev.tobee.telegram.model.GetMeResponse;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.GetMe;
import dev.tobee.telegram.request.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbdAsyncClientTest {

    private final String host = "https://api.telegram.org";
    private final String token = System.getenv("TBD_TELEGRAM_TOKEN");

    @Test
    @DisplayName("Test success getMe action")
    void getMeSuccess() {

        Request<ResponseWrapper<GetMeResponse>> getMe = new GetMe(host, token);

        Assertions.assertFalse(getMe.body().isPresent());
    }
}