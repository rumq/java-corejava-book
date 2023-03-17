package pawarv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class BinWriteZipTest {
    public static void main(String[] args) throws IOException {
        var fout = new FileOutputStream("test.zip");
        var zout = new ZipOutputStream(fout);

        var ze = new ZipEntry("file1.txt");
        zout.putNextEntry(ze);

        zout.

        zout.closeEntry();
        

    }
}
