package pawarv;

import static other.Constants.DATA_DIRECTORY;
import static other.Constants.OUT_FILE_TXT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class ReaderAndWriterTest {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // String inputFile;
        // inputFile = DATA_DIRECTORY + "british_pound.txt" ;   // £ U+00A3 | hex-UTF8 A3       | decimal 163         | hex-UTF16 A3 decimal 163
        // inputFile = DATA_DIRECTORY + "indian_rupee.txt";     // ₹ U+20B9 | hex-UTF8 E2 82 B9 | decimal 226 130 185 | hex-UTF16 20B9 decimal 8353
        // inputFile = DATA_DIRECTORY + "won.txt" ;             // ₩ U+20A9 | hex-UTF8 E2 82 A9 | decimal 226 130 169 | hex-UTF16 20A9 decimal 8361
        // inputFile = DATA_DIRECTORY + "character_a.txt" ;     // a U+0061 | hex-UTF8 61       | decimal 97          | hex-UTF16 0061 decimal 97
        // inputFile = DATA_DIRECTORY + "character_A.txt" ;     // A U+0041 | hex-UTF8 41       | decimal 65          | hex-UTF16 0041 decimal 65
        // inputFile = DATA_DIRECTORY + "character_LF.txt" ;    //LF U+000A | hex-UTF8 0A       | decimal 10          | hex-UTF16 000A decimal 10
        // inputFile = DATA_DIRECTORY + "american_dollar.txt" ; // $ U+0024 | hex-UTF8 24       | decimal 36          | hex-UTF16 0024 decimal 36

        // ONLY ON WINDOWS
        // String inputFile = DATA_DIRECTORY + "character_CR.txt" ; // CR U+000D hex 0D
        // decimal 13

        // String inputFile = DATA_DIRECTORY + "in_file.txt" ; //

        // Get the current working directory
        System.out.println(System.getProperty("user.dir"));

        // 1. read and write one byte at a time
        // try (InputStream in = new FileInputStream(inputFile);
        //         OutputStream out = new FileOutputStream(OUT_FILE_TXT);) {

        //     int c; // read() returns an int, not a byte
        //     // read and write one byte at a time, until end of file
        //     // read() returns -1 at end of file
        //     while ((c = in.read()) != -1) {
        //         out.write(c);
        //         System.out.println(c);
        //     }

        // }

        // 2. read and write one character at a time as UTF-16 decimal
        try (Reader in = new FileReader(inputFile)) {
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
