package dev.tobee.telegram;

import dev.tobee.telegram.ConfigLoader;
import io.helidon.config.Config;

public class BaseClientTest {

    protected static final Config config = new ConfigLoader().loadConfig("config.yaml");
}
