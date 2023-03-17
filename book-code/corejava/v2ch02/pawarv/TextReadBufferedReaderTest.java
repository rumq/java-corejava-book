package pawarv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static other.Constants.*;
/*
 * Demonstrates how to read some text from a file
 */
public class TextReadBufferedReaderTest {
    public static void main(String[] args) throws IOException {

        // From InputStream
        // br <- isr <- is
        // Old fashioned way of reading text from a file
        try (InputStream ins = Files.newInputStream(Path.of(DATA_DIRECTORY, IN_FILE_1_TXT));
             var br = new BufferedReader(
                     new InputStreamReader(ins, StandardCharsets.UTF_8))) {
            boolean done = false;
            while (!done) {
                String line = br.readLine();

                if (line == null) done = true;
                else {
                    System.out.println(line);
                }
            }
        }

        // From BufferedReader
        System.out.println("************ Second");
        try (BufferedReader br = Files.newBufferedReader(Path.of(DATA_DIRECTORY, IN_FILE_1_TXT))) {
            boolean done = false;
            while (!done) {
                var line = br.readLine();
                if (line == null)
                    done = true;
                else
                    System.out.println(line);
            }
        }

        // BufferedReader with Stream
        System.out.println("************ Third");
        try (BufferedReader br = Files.newBufferedReader(Path.of(DATA_DIRECTORY, IN_FILE_1_TXT))) {
            br.lines().forEach(System.out::println);
        }


    }
}
