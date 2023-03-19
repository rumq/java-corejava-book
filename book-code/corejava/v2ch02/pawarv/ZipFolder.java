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

/*
 * @author pawarv
 * @since 2021-03-19
 * @version 1.0
 * 
 * This program zips a folder and all its sub-folders and files.
 * 
 * Change the IN_FOLDER to the folder you want to zip.
 * OUT_FOLDER is the folder where the zip file will be created.
 * ZIP_FILE_NAME is the name of the zip file.
 */
 
public class ZipFolder {

    private static final String IN_FOLDER = USER_HOME + "/temp/zip/in";
    private static final String OUT_FOLDER = USER_HOME + "/temp/zip/out";
    private static final String ZIP_FILE_NAME = "test.zip";

    public static void main(String[] args) {

        zip(IN_FOLDER, OUT_FOLDER, ZIP_FILE_NAME);

    }

    /*
     * This method zips a folder and all its sub-folders and files.
     * 
     * @param inFolder the folder to be zipped
     * @param outFolder the folder where the zip file will be created
     * @param zipFileName the name of the zip file
     * 
     */
    public static void zip(String inFolder, String outFolder, String zipFileName) {

        if (!Files.exists(Path.of(OUT_FOLDER)))
            try {
                Files.createDirectories(Path.of(OUT_FOLDER));
            } catch (IOException e) {
                e.printStackTrace();
            }

        try (var zipos = new ZipOutputStream(new FileOutputStream(outFolder + '/' + zipFileName));) {
            addToZipFile(zipos, inFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * This method recursively adds all the files and folders to the zip output stream.
     * 
     * @param zipos the zip output stream
     * @param folderName the folder to be added to the zip file
     * 
     */
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
