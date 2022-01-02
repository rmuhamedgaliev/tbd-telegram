package dev.tobee.telegram.request.sendobject;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.message.Message;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.request.body.SendInvoiceBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendInvoiceTest {

    @Test
    void checkValidRequest() {
        SendInvoice sendInvoice = new SendInvoice(new SendInvoiceBody(159L, "title", "description", "payload", "token"
                , "rub", List.of(), OptionalInt.empty(), List.of(), Optional.empty(), Optional.empty(),
                Optional.empty(), OptionalInt.empty(), OptionalInt.empty(), OptionalInt.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), OptionalInt.empty(), Optional.empty(), Optional.empty()));

        Assertions.assertEquals(sendInvoice.getResponseType().getType().getTypeName(),
                (new TypeReference<ResponseWrapper<Message>>() {
                }).getType().getTypeName());
        Assertions.assertEquals("sendInvoice", sendInvoice.getMethod());
        Assertions.assertTrue(sendInvoice.getBody().isPresent());
    }
}
