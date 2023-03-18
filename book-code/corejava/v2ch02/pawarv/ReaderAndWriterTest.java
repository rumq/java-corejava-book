package pawarv;

import static other.Constants.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderAndWriterTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {


        // 2. read and write one character at a time as UTF-16 decimal
        try (Reader in = new FileReader(INDIAN_RUPEE)) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.println(c);
            }
        }

        // 3. Write a character to a file using FileWriter
        try (Writer out = new FileWriter(OUT_FILE_TXT)) {
            out.write("₹"); // writing a string 
            out.write(8377); // writing a character using UTF-16 decimal value of ₹
        }

    }
}
