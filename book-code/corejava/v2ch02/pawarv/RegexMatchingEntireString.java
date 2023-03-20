package pawarv;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchingEntireString {
    public static void main(String[] args) {

        // String Literal
        String greeting = "Hello";
        // String greeting = "hell";

        String regex = ".ell."; // match all
        // String regex = "NOTHING"; // match all, non-greedy

        // Using matches() on String
        System.out.println(greeting.matches(regex));

        // Using matches() on Pattern
        System.out.println(Pattern.matches(regex, greeting));

        // Using Pattern and Matcher
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher1 = pattern.matcher(greeting);
        System.out.println("matcher 1 : " + matcher1.matches());

        Matcher matcher2 = pattern.matcher("Hello Hello");
        System.out.println("matcher 2:" + matcher2.matches());

        var list = List.of("Hello", "Hello Hello");

        // Using Pattern and Matcher with Stream
        System.out.println("********* Using Pattern and Matcher with Stream");
        list.stream().map(pattern::matcher)
                .map(Matcher::matches)
                .forEach(System.out::println);

        // asMatchPredicate()
        System.out.println("********* Using Pattern and Matcher with Stream and Predicate");
        list.stream().filter(pattern.asMatchPredicate())
                .forEach(System.out::println);

    }
}
