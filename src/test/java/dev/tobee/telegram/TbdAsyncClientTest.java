package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.model.Message;
import dev.tobee.telegram.model.MessageEntity;
import dev.tobee.telegram.model.MessageEntityType;
import dev.tobee.telegram.model.ParseMode;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.model.UpdateTypes;
import dev.tobee.telegram.model.User;
import dev.tobee.telegram.request.GetMe;
import dev.tobee.telegram.request.GetUpdates;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.SendMessage;
import dev.tobee.telegram.request.SetWebHook;
import dev.tobee.telegram.request.body.GetUpdateBody;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.body.SetWebHookBody;
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

    private final TbdAsyncClient client = Mockito.mock(TbdAsyncClient.class);

    @Test
    @DisplayName("Test success getMe action")
    void getMeSuccess() {
        Mockito.when(client.getRequest(ArgumentMatchers.any()))
                .thenReturn(CompletableFuture.completedFuture(new ResponseWrapper<User>(true,
                        Optional.empty(), Optional.empty(), Optional.empty())));

        testRequestGetMethods(new GetMe(), "getMe", "User");
    }

    @Test
    @DisplayName("Test success getUpdate action")
    void getUpdateSuccess() {
        Mockito.when(client.getRequest(ArgumentMatchers.any()))
                .thenReturn(CompletableFuture.completedFuture(new ResponseWrapper<GetUpdates>(true,
                        Optional.empty(), Optional.empty(), Optional.empty())));

        testRequestGetMethods(new GetUpdates(Optional.empty()), "getUpdates", "Update");
    }

    @Test
    @DisplayName("Test get update valid URL")
    void getValidURLForgetUpdates() {

        var request = new GetUpdates(Optional.of(new GetUpdateBody(OptionalInt.of(100), OptionalInt.of(5),
                OptionalInt.of(100), List.of(UpdateTypes.MESSAGE, UpdateTypes.CALLBACK_QUERY,
                UpdateTypes.CHANNEL_POST))));

        URI uri = URI.create(host + "/" + token + "/" + request.getMethod());

        Assertions.assertNotNull(uri.getHost());
        Assertions.assertNotNull(uri.getQuery());
    }

    @Test
    @DisplayName("Test valid send message")
    void sendMessageValid() {
        Mockito.when(client.postRequest(ArgumentMatchers.any()))
                .thenReturn(CompletableFuture.completedFuture(new ResponseWrapper<Message>(true,
                        Optional.empty(), Optional.empty(), Optional.empty())));

        testRequestPostMethods(
                new SendMessage(
                        new SendMessageBody(
                                144097396,
                                "Slight scenic powder tablet public cult short, anniversary.",
                                Optional.of(ParseMode.MARKDOWN_V2),
                                List.of(new MessageEntity(
                                        MessageEntityType.BOLD,
                                        100,
                                        100,
                                        Optional.of("https://deathqj00yf.mr"),
                                        Optional.empty(),
                                        Optional.empty()
                                )),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty()
                        )), "sendMessage", "Message");
    }

    @Test
    @DisplayName("Test valid send message")
    void setWebHookValid() {
        Mockito.when(client.postRequest(ArgumentMatchers.any()))
                .thenReturn(CompletableFuture.completedFuture(new ResponseWrapper<Boolean>(true,
                        Optional.empty(), Optional.empty(), Optional.empty())));

        testRequestPostMethods(
                new SetWebHook(
                        new SetWebHookBody(
                                "https://deathqj00yf.mr",
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                List.of(),
                                Optional.empty()
                        )), "setWebhook", "Boolean");
    }

    public <T> void testRequestPostMethods(Request<ResponseWrapper<T>> request, String method, String responseType) {
        var response = client.postRequest(request);

        Assertions.assertTrue(request.getBody().isPresent());
        Assertions.assertEquals(method, request.getMethod());
        Assertions.assertTrue(request.getResponseType().getType().getTypeName().contains(responseType));
        Assertions.assertTrue(response.join().ok());
    }

    public <T> void testRequestGetMethods(Request<ResponseWrapper<T>> request, String method, String responseType) {
        var response = client.getRequest(request);

        Assertions.assertTrue(request.getBody().isEmpty());
        Assertions.assertEquals(method, request.getMethod());
        Assertions.assertTrue(request.getResponseType().getType().getTypeName().contains(responseType));
        Assertions.assertTrue(response.join().ok());
    }
}