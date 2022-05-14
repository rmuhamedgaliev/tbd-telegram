package dev.tobee.telegram.service;

import dev.tobee.telegram.BaseRequestsTest;
import dev.tobee.telegram.TdLibInitHandler;
import it.tdlight.jni.TdApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test send inline buttons")
class InlineKeyboardServiceTest extends BaseRequestsTest {

    private final InlineKeyboardService inlineKeyboardService;

    public InlineKeyboardServiceTest() {
        this.inlineKeyboardService = new InlineKeyboardService(CLIENT);
    }

    @Test
    @DisplayName("Send simple inline keyboard")
    public void testSimpleInlineKeyboard() {
        var message = "Hello";
        TdLibInitHandler.TD_LIB_INIT.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            var buttonTitle = (((TdApi.ReplyMarkupInlineKeyboard) update.message.replyMarkup).rows[0][0]).text;
            Assertions.assertEquals(message, buttonTitle);
        });
        var response = inlineKeyboardService.sendInlineKeyboard(DESTINATION_USER, message).join();
        Assertions.assertTrue(response.ok());
    }

    
}
