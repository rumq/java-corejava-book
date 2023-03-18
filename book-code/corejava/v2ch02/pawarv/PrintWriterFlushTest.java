package pawarv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static other.Constants.*;

/**
 * Demonstrates use of autoflush
 */
public class PrintWriterFlushTest {

    public static void main(String[] args) throws FileNotFoundException {

        try (var out = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(OUT_FILE_TXT),
                        StandardCharsets.UTF_8)
                , true);) {
                // )) {
            out.println("First Line - flushed");
            out.println("Second Line - flushed");
            out.println("Third Line - flushed");

        }

    }

}
