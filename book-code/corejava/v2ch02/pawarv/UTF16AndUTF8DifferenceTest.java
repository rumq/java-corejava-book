package pawarv;

import static other.Constants.AMERICAN_DOLLAR;
import static other.Constants.INDIAN_RUPEE;
import static other.Constants.OUT_FILE_TXT;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class UTF16AndUTF8DifferenceTest {
    public static void main(String[] args) throws IOException {

        System.out.println("\n **** Using the utf8 file");

        try (var in = new FileReader(INDIAN_RUPEE, StandardCharsets.UTF_8); // UTF-16 will read as garbage
                var out = new FileWriter(OUT_FILE_TXT, StandardCharsets.UTF_16)) {

            int c;
            while ((c = in.read()) != -1) {
                System.out.printf("Read character: as int %s, as char %s", c, (char) c);
                out.write(c);
            }

        }

        System.out.println("\n\n **** Using the utf16 file");

        try (var in = new FileReader(OUT_FILE_TXT, StandardCharsets.UTF_16)) { // UTF-8 will read as garbage
            int c;
            while ((c = in.read()) != -1) {
                System.out.printf("\nRead character: as int %s, as char %s", c, (char) c);
            }
        }

    }
}
