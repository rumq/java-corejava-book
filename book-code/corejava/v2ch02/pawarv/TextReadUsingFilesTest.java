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

        // readString
        String fileContent = Files.readString(Path.of(IN_OUT_TXT));
        System.out.println("fileContent : \n" + fileContent);

        // readAllLines
        List<String> lines1 = Files.readAllLines(Path.of(IN_OUT_TXT), StandardCharsets.UTF_8);
        System.out.println("lines1 : \n" + lines1);

        // lines
        try (Stream<String> lines2 = Files.lines(Path.of(IN_OUT_TXT))) {
            System.out.println("lines : \n" + lines2.toList());
        }

    }

}
