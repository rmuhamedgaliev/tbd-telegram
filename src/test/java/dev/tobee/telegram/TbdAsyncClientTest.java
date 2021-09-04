package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.GetMeResponse;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.UpdateTypes;
import dev.tobee.telegram.request.GetMe;
import dev.tobee.telegram.request.GetUpdateBody;
import dev.tobee.telegram.request.GetUpdates;
import dev.tobee.telegram.request.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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

        testRequestMethods(new GetMe(), "getMe", "GetMeResponse");
    }

    @Test
    @DisplayName("Test success getUpdate action")
    void getUpdateSuccess() {

        Mockito.when(client.getRequest(ArgumentMatchers.any()))
                .thenReturn(CompletableFuture.completedFuture(new ResponseWrapper<GetUpdates>(true,
                        Optional.empty(), Optional.empty(), Optional.empty())));

        testRequestMethods(new GetUpdates(Optional.empty()), "getUpdates", "Update");
    }

    @Test
    @DisplayName("Test get update valid URL")
    void getValidURLForgetUpdates() {

        var request = new GetUpdates(Optional.of(new GetUpdateBody(OptionalInt.of(100), OptionalInt.of(5),
                OptionalInt.of(100), List.of(UpdateTypes.MESSAGE, UpdateTypes.CALLBACK_QUERY, UpdateTypes.CHANNEL_POST))));

        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());

        Assertions.assertNotNull(uri.getHost());
        Assertions.assertNotNull(uri.getQuery());
    }

    public <T> void testRequestMethods(Request<ResponseWrapper<T>> request, String method, String responseType) {
        var response = client.getRequest(request);

        Assertions.assertTrue(request.getBody().isEmpty());
        Assertions.assertEquals(method, request.getMethod());
        Assertions.assertTrue(request.getResponseType().getType().getTypeName().contains(responseType));
        Assertions.assertTrue(response.join().ok());
    }
}