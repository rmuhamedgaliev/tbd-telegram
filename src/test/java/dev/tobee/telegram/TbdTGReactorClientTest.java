package dev.tobee.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.tobee.telegram.client.TbdTGReactorClient;
import dev.tobee.telegram.request.GetMe;
import dev.tobee.telegram.request.Request;
import dev.tobee.telegram.request.SendMessage;
import dev.tobee.telegram.request.SendPhoto;
import dev.tobee.telegram.request.body.KeyboardButton;
import dev.tobee.telegram.request.body.ParseMode;
import dev.tobee.telegram.request.body.ReplyKeyboardMarkup;
import dev.tobee.telegram.request.body.SendMessageBody;
import dev.tobee.telegram.request.body.SendPhotoBody;
import dev.tobee.telegram.response.GetMeResponse;
import dev.tobee.telegram.response.ResponseWrapper;
import dev.tobee.telegram.response.SendMessageResponse;
import dev.tobee.telegram.response.SendPhotoResponse;
import dev.tobee.telegram.util.DefaultJsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class TbdTGReactorClientTest {

    private final String host = "https://api.telegram.org";
    private final String token = System.getenv("TBD_TELEGRAM_TOKEN");

    private final TbdTGReactorClient tbdTGReactorClient = new TbdTGReactorClient();

    private final DefaultJsonMapper jsonMapper = new DefaultJsonMapper();

    @Test
    @DisplayName("Test success getMe action")
    public void getMeSuccess() {

        Request<ResponseWrapper<GetMeResponse>> getMe = new GetMe(host, token);

        var getMeResponse = Stream.of(tbdTGReactorClient.getRequest(getMe))
                .map(CompletableFuture::join).findFirst();

        Assertions.assertTrue(getMeResponse.get().ok());
        Assertions.assertTrue(getMeResponse.get().result().isPresent());
    }

    @Test
    @DisplayName("Test send message")
    public void sendMessage() throws JsonProcessingException {

        String replyMarkup = jsonMapper.getMapper().writeValueAsString(new ReplyKeyboardMarkup(
                List.of(List.of(new KeyboardButton("abc", Optional.empty(), Optional.empty(),
                        Optional.empty()))),
                Optional.of(Boolean.TRUE), Optional.empty(), Optional.of("bca"), Optional.of(Boolean.TRUE)
        ));

        Request<ResponseWrapper<SendMessageResponse>> sendMessage = new SendMessage(
                host, token,
                new SendMessageBody(353734572, "*yandex*", Optional.of(ParseMode.MARKDOWN_V2),
                 List.of(), Optional.of(Boolean.FALSE),
                        Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(replyMarkup))
        );

        var sendMessageResponse =
                Stream.of(tbdTGReactorClient.postRequest(sendMessage)).map(CompletableFuture::join).findFirst();

        Assertions.assertTrue(sendMessageResponse.get().ok());
        Assertions.assertTrue(sendMessageResponse.get().result().isPresent());
    }

    @Test
    @DisplayName("Test send photo")
    public void sendPhoto() {
        Request<ResponseWrapper<SendPhotoResponse>> sendPhoto = new SendPhoto(
                host, token,
                new SendPhotoBody(
                        353734572,
                        new File("data/1x1.png").toPath(),
                        Optional.empty(), List.of(), Optional.empty(), Optional.empty(), Optional.empty(),
                        Optional.empty()
                )
        );

        var sendPhotoResponse =
                Stream.of(tbdTGReactorClient.postRequest(sendPhoto)).map(CompletableFuture::join).findFirst();

        Assertions.assertTrue(sendPhotoResponse.get().ok());
        Assertions.assertTrue(sendPhotoResponse.get().result().isPresent());
    }
}
