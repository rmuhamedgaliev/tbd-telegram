package dev.tobee.telegram.integration;

import it.tdlight.common.utils.CantLoadLibrary;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TdLibInitHandler implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static boolean started = false;

    public static final TdLibInit TD_LIB_INIT;

    static {
        try {
            TD_LIB_INIT = new TdLibInit();
        } catch (CantLoadLibrary e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            TD_LIB_INIT.startClient();
        }
    }

    @Override
    public void close() {
        TD_LIB_INIT.stopClient();
        System.exit(0);
    }
}
