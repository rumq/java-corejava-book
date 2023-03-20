package pawarv;

import static other.Constants.IN_FILE_2;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchingSubstring {
    public static void main(String[] args) throws IOException {

        // String Literal
        // String greeting = "Hello";
        String greeting = "Hello hello hellYa";

        String regex = ".ell."; // match all
        // String regex = "NOTHING"; // match all, non-greedy

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(greeting);

        // Using find() on Matcher, gives boolean
        boolean found = false;
        while (matcher.find()) {
            found = true;
            System.out.println("Found: " + matcher.group());
            System.out.println("Start: " + matcher.start());
            System.out.println("End: " + matcher.end());
        }
        if (!found) {
            System.out.println("No match found");
        }

        // Using results() on Matcher, gives Stream<MatchResult>
        System.out.println("********* Using stream");
        List<String> matches = pattern.matcher(greeting).results() // Stream<MatchResult>
                .map(x -> String.valueOf(x.start())) // Stream<String>
                .toList();
        System.out.println(matches);

        // Using Scanner, findAll()
        System.out.println("********* Using Scanner");

        try (Scanner scanner = new Scanner(Path.of(IN_FILE_2))) {

            System.out.println("** findAll");
            var resultList = scanner.findAll(pattern).map(MatchResult::group).toList();
            System.out.println(resultList);

        }

        // Using Scanner, findInLine()
        System.out.println("** findInLine");
        try (Scanner scanner = new Scanner(Path.of(IN_FILE_2))) {

            while (scanner.hasNext()) {

                var result1 = scanner.findInLine(pattern);
                var result2 = scanner.nextLine();
                System.out.print(result1 + " ");
                System.out.println(result2);

            }

        }

    }

}
