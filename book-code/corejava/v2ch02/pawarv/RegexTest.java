package pawarv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String regex, greeting;
        
        regex = "[a-d]"; // a, b, c, d
        regex = "\\P{L}";  // Non-Letter
        regex = "\\p{L}";  // Letter
        regex = "\\p{L}+"; // One or more letters
        regex = "\\p{L}*"; // Zero or more letters
        regex = "\\p{L}?"; // Zero or one letter
        regex = "\\p{L}{3}"; // Exactly 3 letters
        regex = "\\p{L}{3,}"; // 3 or more letters
        regex = "\\p{L}{3,5}"; // 3, 4 or 5 letters
        regex = "\\p{L}{3,5}?"; // 3, 4 or 5 letters, non-greedy
        regex = "\\p{L}{3,5}+"; // 3, 4 or 5 letters, one or more

        regex = "a|b"; // a or b
        regex = "a*"; // Zero or more a
        regex = "a?"; // Zero or one a
        regex = "a+"; // One or more a
        regex = "a{3}"; // Exactly 3 a
        regex = "a{3,}"; // 3 or more a
        regex = "a{3,5}"; // 3, 4 or 5 a
        regex = "a{3,5}?"; // 3, 4 or 5 a, non-greedy
        regex = "a{3,5}+"; // 3, 4 or 5 a, one or more

        String[] regexes = {
            "a",               // Matches a
            "a*",              // Matches zero or more a
            "a?",              // Matches zero or one a
            "a+",              // Matches one or more a
            "a{3}",            // Matches exactly 3 a
            "a{3,}",           // Matches 3 or more a
            "a{3,5}",          // Matches 3, 4 or 5 a
            "a{3,5}?",         // Matches 3, 4 or 5 a, non-greedy
            "a{3,5}+",         // Matches 3, 4 or 5 a, one or more
            "a|b",             // Matches a or b
            "[a-d]",           // Matches a, b, c, d
            "\\P{L}",          // Non-Letter
            "\\p{L}",          // Letter
            "\\p{L}+",         // One or more letters
            "\\p{L}*",         // Zero or more letters
            "\\p{L}?",         // Zero or one letter
            "\\p{L}{3}",       // Exactly 3 letters
            "\\p{L}{3,}",      // 3 or more letters
            "\\p{L}{3,5}",     // 3, 4 or 5 letters
            "\\p{L}{3,5}?",    // 3, 4 or 5 letters, non-greedy
            "\\p{L}{3,5}+"     // 3, 4 or 5 letters, one or more

        };

        String[] strings = {
            "0", 
            "a", 
            "aa", 
            "aaa", 
            "aaaa", 
            "aaaaa", 
            "aaaaaa"
        };

        for (String r : regexes) {
            for (String s : strings) {
                System.out.printf("Regex: %s, String: %s, matches: %b%n", r, s, s.matches(r));
            }
        }

        
        

        // String Literal
        greeting = """
                How are you doing? I hope you had a good day.
                Did you know today is 20th March 2023, which is the same as 20/03/2023?
                """;
        // greeting = "ab";




        // Using matches() on String
        System.out.println(greeting.matches(regex));
        
        // Using matches() on Pattern
        System.out.println(Pattern.matches(regex, greeting));

        // Using Pattern and Matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(greeting);
        System.out.println(matcher.matches());

        boolean found = false;
        while (matcher.find()) {
            System.out.println("Found " + matcher.group() + " " + matcher.start()
                    + "-" + matcher.end());
            found = true;

        }
    }
}
