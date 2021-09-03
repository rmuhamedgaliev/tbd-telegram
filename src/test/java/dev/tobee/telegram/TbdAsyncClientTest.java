package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.GetMeResponse;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.Update;
import dev.tobee.telegram.request.GetMe;
import dev.tobee.telegram.request.GetUpdates;
import dev.tobee.telegram.request.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@ExtendWith(MockitoExtension.class)
class TbdAsyncClientTest {

    private final String host = "https://api.telegram.org";

    private final String token = System.getenv("TBD_TELEGRAM_TOKEN");

    private TbdAsyncClient client = Mockito.mock(TbdAsyncClient.class);

    @Test
    @DisplayName("Test success getMe action")
    void getMeSuccess() {

        Mockito.when(client.getRequest(ArgumentMatchers.any()))
                .thenReturn(CompletableFuture.completedFuture(new ResponseWrapper<GetMeResponse>(true,
                        Optional.empty(), Optional.empty(), Optional.empty())));

        Request<ResponseWrapper<GetMeResponse>> request = new GetMe(host, token);

        var response = client.getRequest(request);

        Assertions.assertTrue(response.join().ok());
    }

    @Test
    @DisplayName("Test success getUpdate action")
    void getUpdateSuccess() {

        Mockito.when(client.getRequest(ArgumentMatchers.any()))
                .thenReturn(CompletableFuture.completedFuture(new ResponseWrapper<GetUpdates>(true,
                        Optional.empty(), Optional.empty(), Optional.empty())));

        Request<ResponseWrapper<List<Update>>> request = new GetUpdates(host, token, Optional.empty());

        var response = client.getRequest(request);

        Assertions.assertTrue(response.join().ok());
    }
}