package pawarv;

import java.io.*;
import static other.Constants.*;

/*
 *  Demonstrates reading and writing bytes.
 * 
 */
public class ReadingAndWritingBytesTest {
    public static void main(String[] args) throws IOException {

        

        System.out.println(System.getProperty("user.dir"));
        try (InputStream in = new FileInputStream(SMALL_FILE_TXT);
                OutputStream out = new FileOutputStream(OUT_FILE_TXT);) {

            int c;

            // read and write one byte at a time, until end of file
            // read() returns -1 at end of file
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        }

        try (InputStream in = new FileInputStream(OUT_FILE_TXT);) {

            int bytesAvailable = in.available();
            System.out.println("Bytes available: " + bytesAvailable);

            // read all bytes into a byte array
            // doesn't block if bytesAvailable is 0
            if (bytesAvailable > 0) {
                byte[] bytes = new byte[bytesAvailable];
                in.read(bytes);
                System.out.println("Bytes read: " + bytes.length);
                System.out.println("Output file contents:"  + new String(bytes));
            }

        }

    }
}