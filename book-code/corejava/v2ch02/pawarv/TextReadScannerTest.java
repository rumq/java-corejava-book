package pawarv;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import other.Constants;

public class TextReadScannerTest {
    public static void main(String[] args) throws IOException {


        // Default delimiter is whiyespace
        Path filePath = Path.of(Constants.IN_OUT_TXT);
        try (Scanner in = new Scanner(filePath);) {
            System.out.println("*** Default delimiter");
            while (in.hasNext())
                System.out.println(in.next());

        }

        // Use non unicode character
        try (Scanner in2 = new Scanner(filePath);) {
            System.out.println("***** non unicode character");
            in2.useDelimiter("\\PL+");
            while (in2.hasNext()) {
                System.out.println(in2.next());
            }
        }
    }
}
