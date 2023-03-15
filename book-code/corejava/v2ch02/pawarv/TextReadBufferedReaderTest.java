package pawarv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static pawarv.Constants.IN_OUT_TXT;

public class TextReadBufferedReaderTest {
    public static void main(String[] args) throws IOException {

        // From InputStream
        // br <- isr <- is
        try (InputStream ins = Files.newInputStream(Path.of(IN_OUT_TXT));
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
        try (BufferedReader br = Files.newBufferedReader(Path.of(IN_OUT_TXT))) {
            boolean done = false;
            while (!done) {
                var line = br.readLine();
                if (line == null)
                    done = true;
                else
                    System.out.println(line);
            }
        }


    }
}
