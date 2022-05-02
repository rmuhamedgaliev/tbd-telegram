package dev.tobee.telegram;

import it.tdlight.client.APIToken;
import it.tdlight.client.AuthenticationData;
import it.tdlight.client.SimpleTelegramClient;
import it.tdlight.client.TDLibSettings;
import it.tdlight.common.Init;
import it.tdlight.common.utils.CantLoadLibrary;

import java.nio.file.Paths;

public class TdLibInit {

    private final SimpleTelegramClient client;

    public TdLibInit() throws CantLoadLibrary {
        Init.start();

        var settings = TDLibSettings.create(new APIToken(
                Integer.parseInt(System.getenv("TBD_TELEGRAM_TEST_API_ID")),
                System.getenv("TBD_TELEGRAM_TEST_HASH")
        ));

        var sessionPath = Paths.get("tdlight-session");
        settings.setDatabaseDirectoryPath(sessionPath.resolve("data"));
        this.client = new SimpleTelegramClient(settings);
    }

    public SimpleTelegramClient getClient() {
        return client;
    }

    public void startClient() {
        var authenticationData = AuthenticationData.user(79933884802L);
        client.start(authenticationData);
    }

    public void stopClient() {
        try {
            client.closeAndWait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
