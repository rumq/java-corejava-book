package pawarv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import static other.Constants.USER_HOME;
public class SimpleZipOutput {
    public static void main(String[] args) {

        try (var zipos = new ZipOutputStream(new FileOutputStream(USER_HOME + "/temp/test.zip"));) {

            var ze = new ZipEntry("test1.txt");
            zipos.putNextEntry(ze);
            zipos.write("Hello World - 1".getBytes());
            zipos.closeEntry();

            var ze2 = new ZipEntry("test2.txt");
            zipos.putNextEntry(ze2);
            zipos.write("Hello World - 2".getBytes());
            zipos.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
