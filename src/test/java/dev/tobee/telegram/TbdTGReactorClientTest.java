package dev.tobee.telegram;

import dev.tobee.telegram.client.TbdAsyncClient;
import dev.tobee.telegram.util.DefaultJsonMapper;

class TbdAsyncClientTest {

    private final String host = "https://api.telegram.org";
    private final String token = System.getenv("TBD_TELEGRAM_TOKEN");

    private final TbdAsyncClient tbdTGReactorClient = new TbdAsyncClient(true);

    private final DefaultJsonMapper jsonMapper = new DefaultJsonMapper();

//    @Test
//    @DisplayName("Test success getMe action")
//    void getMeSuccess() {
//
//        Request<ResponseWrapper<GetMeResponse>> getMe = new GetMe(host, token);
//
//        var getMeResponse = Stream.of(tbdTGReactorClient.getRequest(getMe))
//                .map(CompletableFuture::join).findFirst();
//
//        Assertions.assertTrue(getMeResponse.get().ok());
//        Assertions.assertTrue(getMeResponse.get().result().isPresent());
//    }

//    @Test
//    @DisplayName("Test send message")
//    void sendMessage() throws JsonProcessingException {
//
//        String replyMarkup = jsonMapper.getMapper().writeValueAsString(new ReplyKeyboardMarkup(
//                List.of(List.of(new KeyboardButton("abc", Optional.empty(), Optional.empty(),
//                        Optional.empty()))),
//                Optional.of(Boolean.TRUE), Optional.empty(), Optional.of("bca"), Optional.of(Boolean.TRUE)
//        ));
//
//        Request<ResponseWrapper<SendMessageResponse>> sendMessage = new SendMessage(
//                host, token,
//                new SendMessageBody(353734572, "*yandex*", Optional.of(ParseMode.MARKDOWN_V2),
//                        List.of(), Optional.of(Boolean.FALSE),
//                        Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(replyMarkup))
//        );
//
//        var sendMessageResponse =
//                Stream.of(tbdTGReactorClient.postRequest(sendMessage)).map(CompletableFuture::join).findFirst();
//
//        Assertions.assertTrue(sendMessageResponse.get().ok());
//        Assertions.assertTrue(sendMessageResponse.get().result().isPresent());
//    }

//    @Test
//    @DisplayName("Test send photo")
//    void sendPhoto() {
//        Request<ResponseWrapper<SendPhotoResponse>> sendPhoto = new SendPhoto(
//                host, token,
//                new SendPhotoBody(
//                        353734572,
//                        new File("data/1x1.png").toPath(),
//                        Optional.empty(), List.of(), Optional.empty(), Optional.empty(), Optional.empty(),
//                        Optional.empty()
//                )
//        );
//
//        var sendPhotoResponse =
//                Stream.of(tbdTGReactorClient.postRequest(sendPhoto)).map(CompletableFuture::join).findFirst();
//
//        Assertions.assertTrue(sendPhotoResponse.get().ok());
//        Assertions.assertTrue(sendPhotoResponse.get().result().isPresent());
//    }
}