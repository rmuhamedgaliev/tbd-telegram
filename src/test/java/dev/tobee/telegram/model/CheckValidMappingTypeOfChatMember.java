package dev.tobee.telegram.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.tobee.telegram.model.chat.ChatMemberStatus;
import dev.tobee.telegram.model.message.ResponseWrapper;
import dev.tobee.telegram.model.message.Update;
import dev.tobee.telegram.util.DefaultJsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckValidMappingTypeOfChatMember {
    private final static DefaultJsonMapper MAPPER = new DefaultJsonMapper();
    @Test
    public void checkValidMappingOfTypeChatMember() {
        try (var jsonValueFileStream = getClass().getClassLoader()
                .getResourceAsStream("responses/get_chat_member_update.json")
        ) {
            ResponseWrapper<List<Update>> updates =
                    MAPPER.parseResponse(new String(jsonValueFileStream.readAllBytes()), new TypeReference<>() {
                    });

            Assertions.assertNotNull(updates);
            Assertions.assertEquals(ChatMemberStatus.LEFT, updates.result().get().get(0)
                    .myChatMember().get()
                    .oldChatMember().status()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
