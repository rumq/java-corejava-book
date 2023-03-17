package pawarv;

import static other.Constants.DATA_DIRECTORY;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

class TestInputAndOutputStreamReader {
    public static void main(String[] args) throws IOException {

        System.out.println("\n **** Using the utf8 file");
        try (var in = new InputStreamReader(
                new FileInputStream(DATA_DIRECTORY + "indian_rupee.txt")); // Default on systems
                // new FileInputStream(DATA_DIRECTORY + "indian_rupee.txt"), StandardCharsets.UTF_8); // Default on my system
                // new FileInputStream(DATA_DIRECTORY + "indian_rupee.txt"), // StandardCharsets.UTF_16); // Will read as garbage
                var out = new OutputStreamWriter(
                        // can write as UTF-16, provided we read as such later
                        new FileOutputStream(DATA_DIRECTORY + "indian_rupee_utf16.txt"), StandardCharsets.UTF_16)) {
            // new FileOutputStream(DATA_DIRECTORY + "indian_rupee_utf16.txt"),
            // StandardCharsets.UTF_8)) {

            int c;
            while ((c = in.read()) != -1) {
                System.out.printf("Read character: as int %s, as char %s", c, (char) c);
                out.write(c);
            }

        }

        System.out.println("\n\n **** Using the utf16 file");
        try (var in = new InputStreamReader(
                // As we are writing as UTF-16, it's ok to read as UTF-16
                new FileInputStream(DATA_DIRECTORY + "indian_rupee_utf16.txt"), StandardCharsets.UTF_16)) {
                // new FileInputStream(DATA_DIRECTORY + "indian_rupee_utf16.txt"))) { // Read as UTF-8 and therefore garbage
            int c;
            while ((c = in.read()) != -1) {
                System.out.printf("\nRead character: as int %s, as char %s", c, (char) c);
            }
        }

        System.out.println("\n");

    }
}
