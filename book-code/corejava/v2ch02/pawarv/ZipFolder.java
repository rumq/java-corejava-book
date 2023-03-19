package pawarv;

import static other.Constants.USER_HOME;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {

    private static final String IN_FOLDER = USER_HOME + "/temp/zip/in";
    private static final String OUT_FOLDER = USER_HOME + "/temp/zip/out";
    private static final String ZIP_FILE_NAME = "test.zip";

    public static void main(String[] args) throws IOException {

        zip(IN_FOLDER, OUT_FOLDER, ZIP_FILE_NAME);

    }

    public static void zip(String inFolder, String outFolder, String zipFileName)
            throws FileNotFoundException, IOException {

        try (var zipos = new ZipOutputStream(new FileOutputStream(outFolder + '/' + zipFileName));) {
            addToZipFile(zipos, inFolder);
        }

    }

    private static void addToZipFile(ZipOutputStream zipos, String folderName)
            throws IOException, FileNotFoundException {

        var paths = Files.list(Path.of(folderName)).toList();
        for (var path : paths) {

            if (Files.isRegularFile(path)) {

                String relPath = Path.of(IN_FOLDER).relativize(path).toString();
                System.out.println(relPath);

                try (var in = new FileInputStream(path.toString())) {

                    zipos.putNextEntry(new ZipEntry(relPath));
                    zipos.write(in.readAllBytes());
                    zipos.closeEntry();
                }
            }

            if (Files.isDirectory(path)) {
                addToZipFile(zipos, path.toString());
            }

        }
    }
}
