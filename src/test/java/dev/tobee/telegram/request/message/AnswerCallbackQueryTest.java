package dev.tobee.telegram.request.message;

import java.util.Optional;
import java.util.OptionalLong;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.ResponseWrapper;
import dev.tobee.telegram.request.body.AnswerCallbackQueryBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnswerCallbackQueryTest {

    @Test
    void checkValidRequest() {
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery(
                new AnswerCallbackQueryBody("layer", Optional.empty(), Optional.empty(), Optional.empty(), OptionalLong.empty())
        );

        Assertions.assertEquals(answerCallbackQuery.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Boolean>>() {}).getType().getTypeName());
        Assertions.assertEquals("answerCallbackQuery", answerCallbackQuery.getMethod());
        Assertions.assertTrue(answerCallbackQuery.getBody().isPresent());
    }
}
