package net.rumq;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import static net.rumq.Constants.*;

/**
 * Demonstrates how to write some text to a file
 */
public class TextWriteTest {
    public static void main(String[] args) throws IOException {

        try (var out = new PrintWriter(IN_OUT_TXT, StandardCharsets.UTF_8);) {

            out.println("First Line");
            out.println("Second Line");
        }

    }
}
