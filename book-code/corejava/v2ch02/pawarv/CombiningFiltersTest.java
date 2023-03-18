package pawarv;

import static other.Constants.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class CombiningFiltersTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try (InputStream in = new FileInputStream(IN_FILE)) {

            int c;
            while ((c = in.read()) != -1) {
                System.out.println(c);
            }

        }

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(IN_FILE), 1024)) {

            System.out.println(in.available());

            int c;
            while ((c = in.read()) != -1) {
                System.out.println(c);
            }
        }

        System.out.println("************");
        try (LineNumberReader reader = new LineNumberReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(IN_FILE_1))))) {

            reader.skip(3);

            int c;
            while ((c = reader.read()) != -1) {
                System.out.println("Line number :" + reader.getLineNumber());
                System.out.println(c);
            }
        }

    }

}
