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
 *  See the ReadingAndWritingCharacters for understanding Unicode, UTF-8, UTF-16
 *  
 */
public class InputStreamAndOutputStreamTest {

    public static void main(String[] args) throws IOException {

        // 1. read one byte at a time
        try (InputStream in = new FileInputStream(INDIAN_RUPEE);) {

            int c; // read() returns an int
            // read one byte at a time, until end of file
            // read() returns -1 at end of file
            while ((c = in.read()) != -1) {
                System.out.println(c);
            }

        }

        // 2. read bytes without blocking
        try (InputStream in = new FileInputStream(IN_FILE);) {

            int bytesAvailable = in.available();
            System.out.println("Bytes available: " + bytesAvailable);

            // read all bytes into a byte array
            // doesn't block if bytesAvailable is 0
            if (bytesAvailable > 0) {
                byte[] bytes = new byte[bytesAvailable];
                in.read(bytes); // read into byte array
                System.out.println("Bytes read: " + bytes.length);
                System.out.println("Contents:" + new String(bytes));
            }

        }

        // 3. Using InputStream.readAllBytes() method
        // read all bytes into a byte array
        try (InputStream in = new FileInputStream(IN_FILE);) {
            byte[] bytes = in.readAllBytes();
            System.out.println("Bytes read: " + bytes.length);
            System.out.println("Output file contents:" + new String(bytes));
        }

        // easier to do with readAllBytes() method
        byte[] bytes = Files.readAllBytes(Paths.get(IN_FILE));
        System.out.println("Bytes read: " + bytes.length);
        System.out.println("Output file contents:" + new String(bytes));

        // 4. Read and write at the same time
        try (InputStream in = new FileInputStream(IN_FILE);
                OutputStream out = new FileOutputStream(OUT_FILE_TXT);) {

            int c; // read() returns an int, not a byte
            // read and write one byte at a time, until end of file
            // read() returns -1 at end of file
            while ((c = in.read()) != -1) {
                out.write(c);
                System.out.println(c);
            }

        }

        // 5. Write to output stream, variety of ways
        try (OutputStream out = new FileOutputStream(OUT_FILE_TXT);) {

            out.write(65); // A as decimal
            out.write(0x41); // A as hex
            out.write('A'); // A as char            
            out.write(0b01000001); // as binary

            var bytesArray = "abc".getBytes(); // From String
            out.write(bytesArray);

            out.write(36); // $

            // 3 bytes for the Rupee symbol as decimal
            out.write(226);
            out.write(130);
            out.write(185);


            // 3 bytes for the Rupee symbol as hex
            out.write(0xE2); 
            out.write(0x82); 
            out.write(0xB9); 

        }

    }
}