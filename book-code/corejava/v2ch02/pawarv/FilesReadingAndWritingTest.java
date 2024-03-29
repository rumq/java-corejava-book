package pawarv;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

import static other.Constants.*;

public class FilesReadingAndWritingTest {


    public static void main(String[] args) throws IOException {

        /*
         * READING FILES
         */
        // A) readString - if the file is small
        String fileContent = Files.readString(Path.of(IN_FILE_1));
        System.out.println("fileContent : \n" + fileContent);

        // B) readAllLines - if the file is small and if we want to read the file as a
        // list of lines
        List<String> lines1 = Files.readAllLines(Path.of(IN_FILE_1), StandardCharsets.UTF_8);
        System.out.println("lines1 : \n" + lines1);

        // C) lines - if the file is large and if we want to read the file as a stream
        // of lines
        try (Stream<String> lines2 = Files.lines(Path.of(IN_FILE_1))) {
            System.out.println("lines : \n" + lines2.toList());
        }

        // D) readAllBytes -
        byte[] bytes = Files.readAllBytes(Path.of(IN_FILE_1));
        System.out.println("bytes : \n" + bytes.length);

        /*
         * WRITING FILES
         */
        // A) writeString - from a string
        Files.writeString(Path.of(OUT_FILE_1), "out file data 1", StandardCharsets.UTF_8);

        // C) write - from list of lines
        var lines = List.of("oline 1", "oline 2", "oline 3");
        Files.write(Path.of(OUT_FILE_1), lines, StandardCharsets.UTF_8);

        // D) write - from byte array
        byte[] outBytes = "out file data 2".getBytes(StandardCharsets.UTF_8);
        Files.write(Path.of(OUT_FILE_1), outBytes);

        // E) write - append
        Files.write(Path.of(OUT_FILE_1), lines, StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);

        /*
         *  INPUT AND OUTPUT STREAMS 
         */

        // A) getInputStream

        try (InputStream in = Files.newInputStream(Path.of(INDIAN_RUPEE))) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.printf("Read character: as int %s, as char %s \n", c, (char) c);
                
            }
        }
        // B) getOutputStream

        try(OutputStream out = Files.newOutputStream(Path.of(OUT_FILE_1), StandardOpenOption.APPEND)) {
            out.write("out file data 3".getBytes(StandardCharsets.UTF_8));
        }

        /*
         *  READER AND WRITER
         */

        // A) newBufferedReader

        try(var reader = Files.newBufferedReader(Path.of(INDIAN_RUPEE), StandardCharsets.UTF_8)) {
            int c;
            while((c = reader.read()) != -1) {
                System.out.printf("Read character: as int %s, as char %s \n", c, (char) c);
            }
        }

        // B) newBufferedWriter

        try(var writer = Files.newBufferedWriter(Path.of(OUT_FILE_1), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write("out file data 4");
        }
        
    }

}
