package pawarv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplaceTest {
    public static void main(String[] args) {

        // replaceAll on Matcher
        Matcher matcher = Pattern.compile(":").matcher("a : b : c");
        String result = matcher.replaceAll("-");
        System.out.println(result);

        // replaceAll on String
        String result2 = "a : b : c".replaceAll(":", "-");
        System.out.println(result2);

        // replaceAll on String with group reference
        String result3 = "5:10".replaceAll(
                "(\\d{1,2}):(?<minutes>\\d{2})",
                "Wake up at $1 hour and ${minutes} minutes, if you don't want to be late !!!");
        System.out.println(result3);

        // replaceAll using a lambda 
        String result4 = Pattern.compile("\\pL{6,}")
                .matcher("India Albania US UK Germany")
                .replaceAll(m -> m.group().toUpperCase());

        System.out.println(result4);

    }
}
