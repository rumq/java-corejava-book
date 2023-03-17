package pawarv;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import other.Constants;

import static pawarv.Constants.*;

/**
 * Demonstrates how to write some text to a file
 */
public class TextWriteTest {
    public static void main(String[] args) throws IOException {

        try (var out = new PrintWriter(Constants.IN_OUT_TXT, StandardCharsets.UTF_8);) {

            String one = "First";
            String two = "Second";
            double three = 3.0;
            out.print(one);
            out.print(", ");
            out.print(two);
            out.print(", ");
            out.print(three);
            out.println();
        }

    }
}
