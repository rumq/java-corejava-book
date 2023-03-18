package pawarv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static other.Constants.*;
/*
 * New methods in BufferedReader lines()
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {

        // Use readLine() and while loop (old way)
        try (var br = new BufferedReader(new FileReader(IN_FILE, StandardCharsets.UTF_8))) {                     
            boolean done = false;
            while (!done) {
                String line = br.readLine();

                if (line == null) done = true;
                else {
                    System.out.println(line);
                }
            }
        }

        // From BufferedReader (new way 1)
        System.out.println("************ Second");
        try (var br = new BufferedReader(new FileReader(IN_FILE, StandardCharsets.UTF_8))) {                     
            br.lines().forEach(System.out::println);
        }

        // BufferedReader with Stream (new way 2)
        System.out.println("************ Third");
        try (BufferedReader br = Files.newBufferedReader(Path.of(DATA_DIRECTORY, IN_FILE_1_TXT))) {
            br.lines().forEach(System.out::println);
        }


    }
}
