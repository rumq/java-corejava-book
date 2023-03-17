package pawarv;

import static other.Constants.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class FilesCreatingTest {
    public static void main(String[] args) throws IOException {

        // exists ?
        var result = Files.exists(Path.of(DATA_DIRECTORY));
        System.out.println("Does the directory exist? " + result);

        // exists ?
        result = Files.exists(Path.of("random string"));
        System.out.println("Does the directory exist? " + result);

        // isDirectory ?
        result = Files.isDirectory(Path.of(DATA_DIRECTORY));
        System.out.println("Is the directory a directory? " + result);

        // isDirectory ?
        result = Files.isDirectory(Path.of("random string"));
        System.out.println("Is the directory a directory? " + result);

        // isRegularFile ?
        result = Files.isRegularFile(Path.of(DATA_DIRECTORY, INDIAN_RUPEE_TXT ) );
        System.out.println("Is the file a regular file? " + result);  

        // createFile
        Files.createFile(Path.of(DATA_DIRECTORY + "temp1.txt"));
        System.out.println("Created a file ? " + Files.exists(Path.of(DATA_DIRECTORY + "temp1.txt")));

        // copy
        Files.copy(Path.of(DATA_DIRECTORY + INDIAN_RUPEE_TXT),  Path.of(DATA_DIRECTORY + "temp2.txt"));

        // move
        Files.move(Path.of(DATA_DIRECTORY + "temp1.txt"), Path.of(DATA_DIRECTORY + "temp3.txt"));

        // createDirectories
        Files.createDirectories(Path.of(DATA_DIRECTORY + "temp4/temp5/temp6"));
        
        // createTempDirectory
        var tempDirectory = Files.createTempDirectory(Path.of(DATA_DIRECTORY), "test");

        // createTempFile
        var tempFile = Files.createTempFile(Path.of(DATA_DIRECTORY), "test", ".txt");


        //cleanup
        Files.delete(Path.of(DATA_DIRECTORY + "temp4/temp5/temp6"));
        Files.delete(Path.of(DATA_DIRECTORY + "temp4/temp5"));
        Files.delete(Path.of(DATA_DIRECTORY + "temp4"));
        
        Files.delete(tempDirectory);
        Files.delete(tempFile);

        Files.deleteIfExists(Path.of(DATA_DIRECTORY + "temp1.txt"));
        Files.deleteIfExists(Path.of(DATA_DIRECTORY + "temp2.txt"));
        Files.deleteIfExists(Path.of(DATA_DIRECTORY + "temp3.txt"));


    }
}
