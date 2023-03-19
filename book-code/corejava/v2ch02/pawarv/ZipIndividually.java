package pawarv;

import static other.Constants.USER_HOME;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * @author pawarv
 * @since 2021-03-19
 * @version 1.0
 * 
 * This program zips each folder and its contents within the input folder as a separate zip file.
 * 
 */
public class ZipIndividually {

    private static final String IN_FOLDER = USER_HOME + "/temp/zip/in";    
    private static final String OUT_FOLDER = USER_HOME + "/temp/zip/out";

    public static void main(String[] args) throws IOException {

        zip(IN_FOLDER, OUT_FOLDER);

    }

    /*
     * This method zips each folder and its contents within the input folder as a separate zip file.
     * 
     * @param inFolder the folder that contains the folders to be zipped
     * @param outFolder the folder where the zip files will be created
     */
    public static void zip (String inFolder, String outFolder) throws IOException {
        var paths = Files.list(Path.of(inFolder)).toList();

        for (var path : paths) {
            if (Files.isDirectory(path)) {
                ZipFolder.zip(path.toString(), outFolder, path.getFileName().toString() + ".zip");
            }
        }

    }
}
