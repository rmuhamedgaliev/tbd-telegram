package dev.tobee.telegram.requests;

import dev.tobee.telegram.TdLibInitHandler;
import dev.tobee.telegram.client.TbdAsyncClient;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TdLibInitHandler.class})
public class BaseRequestsTest {
    protected static final String HOST = "https://api.telegram.org";
    protected static final TbdAsyncClient BOT = new TbdAsyncClient(false, HOST, System.getenv("TBD_TELEGRAM_TOKEN"));
    protected static final long DESTINATION_USER = 5338423141L;
}
