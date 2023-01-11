import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {

        // Check that writeTo can accept any OutputStream
        writeTo(System.out, "Written using System.out\n");

        // Check that we can collect into a ByteArrayOutputStream to print out
        String data = "Written using ByteArrayOutputStream\n";
        var baos = new ByteArrayOutputStream();
        writeTo(baos, data);
        System.out.println(baos.toString());

    }

    static void writeTo(OutputStream out, String a) throws IOException {
        out.write(a.getBytes());
    }
}
