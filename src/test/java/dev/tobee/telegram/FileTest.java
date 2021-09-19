package dev.tobee.telegram;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileTest {

    @Test
    public void testFile() throws IOException {
        File file = new File("data/1x1.png");

        InputStream is = new FileInputStream(file);

//        String mimeType = Files.probeContentType(path);
//        String filename = path.getFileName();
        byte[] bytes = is.readAllBytes();
    }
}
