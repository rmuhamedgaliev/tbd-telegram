package dev.tobee.telegram.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

@EnabledIfEnvironmentVariable(named = "integration", matches = "true")
public class TestSendMessage {

    @Test
    public void sendMessageTest() {
        Assertions.assertTrue(2 + 2 > 4);
    }
}
