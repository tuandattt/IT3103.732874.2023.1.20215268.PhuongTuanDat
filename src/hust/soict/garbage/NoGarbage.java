package hust.soict.garbage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    private StringBuilder outputStringBuilder;

    public NoGarbage() {
        outputStringBuilder = new StringBuilder();
    }

    public void createGarbage() {
        String filename = "test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        startTime = System.currentTimeMillis();

        outputStringBuilder.setLength(0); // Clear the StringBuilder for reuse

        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }

        endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
