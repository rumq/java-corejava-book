package pawarv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static java.util.stream.Collectors.*;

public class ParallelStreamsTest {
    public static void main(String[] args) throws IOException {

        var list = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        var parallelStream = list.parallelStream();
        System.out.println("parallelStream.isParallel(): " + parallelStream.isParallel());

        var sequentialStream = parallelStream.sequential();
        System.out.println("sequentialStream.isParallel(): " + sequentialStream.isParallel());

        var words = Files.readString(Path.of(other.Constants.ALICE_TXT));
        var wordList = List.of(words.split(other.Constants.REGX_SPLIT_WORDS));

        // Case 1
        // How many words there are in the list that have the lengths 1, 2, 3, ..., 9
        var wordLengthsArray = new int[10];
        // wordList.parallelStream() // this is wrong
        wordList.stream()
                .forEach(s -> {
                    if (s.length() < 10) {
                        wordLengthsArray[s.length()]++;
                    }
                });

        System.out.println("wordLengthsArray: ");
        for (int i = 0; i < wordLengthsArray.length; i++) {
            System.out.print(wordLengthsArray[i] + " ");
        }

        // Case 2
        var wordLengthsMap = wordList.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(
                        groupingBy(String::length,  // classifier
                                counting())); // downStream collector
        System.out.println("\nwordLengthsMap: \n" + wordLengthsMap);

    }
}
