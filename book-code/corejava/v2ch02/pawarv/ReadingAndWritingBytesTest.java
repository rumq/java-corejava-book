package pawarv;


import static other.Constants.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 *  Demonstrates reading and writing bytes.
 * 
 */
public class ReadingAndWritingBytesTest {
    

    public static void main(String[] args) throws IOException {

        // String inputFile = DATA_DIRECTORY + "american_dollar.txt" ; // $ U+0024  | hex-UTF8 24         | decimal 36          | hex-UTF16 0024 decimal 36
        // String inputFile = DATA_DIRECTORY + "british_pound.txt" ;   // £ U+00A3  | hex-UTF8 A3         | decimal 163         | hex-UTF16 A3 decimal 163
        String inputFile = DATA_DIRECTORY + INDIAN_RUPEE_TXT ;    // ₹ U+20B9  | hex-UTF8 E2  82 B9  | decimal 226 130 185 | hex-UTF16 20B9 decimal 8353
        // String inputFile = DATA_DIRECTORY + "won.txt" ;             // ₩ U+20A9  | hex-UTF8 E2  82 A9  | decimal 226 130 169 | hex-UTF16 20A9 decimal 8361
        // String inputFile = DATA_DIRECTORY + "character_a.txt" ;     // a U+0061  | hex-UTF8 61         | decimal 97          | hex-UTF16 0061 decimal 97
        // String inputFile = DATA_DIRECTORY + "character_A.txt" ;     // A U+0041  | hex-UTF8 41         | decimal 65          | hex-UTF16 0041 decimal 65
        // String inputFile = DATA_DIRECTORY + "character_LF.txt" ;    //LF U+000A  | hex-UTF8 0A         | decimal 10          | hex-UTF16 000A decimal 10
        
        // ONLY ON WINDOWS
        // String inputFile = DATA_DIRECTORY + "character_CR.txt" ; // CR U+000D  hex 0D decimal 13

        // String inputFile = DATA_DIRECTORY + "in_file.txt" ; // 


        
        // Get the current working directory
        System.out.println(System.getProperty("user.dir"));

        // 1. read and write one byte at a time
        try (InputStream in = new FileInputStream(inputFile);
                OutputStream out = new FileOutputStream(OUT_FILE_TXT);) {

            int c; // read() returns an int, not a byte
            // read and write one byte at a time, until end of file
            // read() returns -1 at end of file
            while ((c = in.read()) != -1) {
                out.write(c);
                System.out.println(c);
            }

        }

        // 2. read and write a block of bytes without blocking
        try (InputStream in = new FileInputStream(OUT_FILE_TXT);) {

            int bytesAvailable = in.available();
            System.out.println("Bytes available: " + bytesAvailable);

            // read all bytes into a byte array
            // doesn't block if bytesAvailable is 0
            if (bytesAvailable > 0) {
                byte[] bytes = new byte[bytesAvailable];
                in.read(bytes); // read into byte array
                System.out.println("Bytes read: " + bytes.length);
                System.out.println("Output file contents:"  + new String(bytes));
            }

        }

        // 3. Using InputStream.readAllBytes() method
        // read all bytes into a byte array
        try(InputStream in = new FileInputStream(OUT_FILE_TXT);) {
            byte[] bytes = in.readAllBytes();
            System.out.println("Bytes read: " + bytes.length);
            System.out.println("Output file contents:"  + new String(bytes));
        }

        // easier to do with readAllBytes() method
        byte[] bytes = Files.readAllBytes(Paths.get(OUT_FILE_TXT));
        System.out.println("Bytes read: " + bytes.length);
        System.out.println("Output file contents:"  + new String(bytes));

    }
}