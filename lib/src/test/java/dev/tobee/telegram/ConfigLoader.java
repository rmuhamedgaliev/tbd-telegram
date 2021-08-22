package dev.tobee.telegram;

import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.config.encryption.ConfigProperties;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;

public class ConfigLoader {

    public Config loadConfig(String classpathResources) {
        checkMasterPasswordKey();

        return Config.builder()
                .sources(ConfigSources.create(Map.of(ConfigProperties.REQUIRE_ENCRYPTION_CONFIG_KEY, "true")))
                .sources(ConfigSources.classpath(classpathResources))
                .build();
    }

    private void checkMasterPasswordKey() {
        if (System.getenv(ConfigProperties.MASTER_PASSWORD_ENV_VARIABLE) == null) {
            throw new RuntimeException("Can't start application. Please set env variable "
                    + ConfigProperties.MASTER_PASSWORD_ENV_VARIABLE);
        }
    }

}
