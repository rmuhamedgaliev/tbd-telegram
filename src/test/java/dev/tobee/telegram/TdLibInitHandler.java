package dev.tobee.telegram;

import it.tdlight.common.utils.CantLoadLibrary;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TdLibInitHandler implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    public static final TdLibInit TD_LIB_INIT;
    private static boolean started = false;

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

            context.getRoot()
                   .getStore(ExtensionContext.Namespace.GLOBAL)
                   .put("TestDataSetup-started", this);
        }
    }

    @Override
    public void close() {
        TD_LIB_INIT.stopClient();
        System.exit(0);
    }
}
