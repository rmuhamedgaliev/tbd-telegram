package dev.tobee.telegram;

import it.tdlight.common.utils.CantLoadLibrary;
import it.tdlight.jni.TdApi;

public class TdLibHandlerTestRunner {

    public static void main(String[] args) throws CantLoadLibrary, InterruptedException {
        TdLibInit libInit = new TdLibInit();
        libInit.getClient().addUpdateHandler(TdApi.UpdateNewMessage.class, update -> {
            System.out.println();
        });
        libInit.startClient();
        libInit.getClient().waitForExit();
    }
}
