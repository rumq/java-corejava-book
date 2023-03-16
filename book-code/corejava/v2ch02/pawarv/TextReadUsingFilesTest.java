package pawarv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static pawarv.Constants.IN_OUT_TXT;

public class TextReadUsingFilesTest {
    public static void main(String[] args) throws IOException {

        // readString - if the file is small
        String fileContent = Files.readString(Path.of(IN_OUT_TXT));
        System.out.println("fileContent : \n" + fileContent);

        // readAllLines - if the file is small and if we want to read the file as a list of lines
        List<String> lines1 = Files.readAllLines(Path.of(IN_OUT_TXT), StandardCharsets.UTF_8);
        System.out.println("lines1 : \n" + lines1);

        // lines - if the file is large and if we want to read the file as a stream of lines        
        try (Stream<String> lines2 = Files.lines(Path.of(IN_OUT_TXT))) {
            System.out.println("lines : \n" + lines2.toList());
        }

    }

}
