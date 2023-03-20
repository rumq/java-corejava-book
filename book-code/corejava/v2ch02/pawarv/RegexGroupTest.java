package pawarv;

import java.util.regex.Pattern;

public class RegexGroupTest {
    public static void main(String[] args) {

        var regex = "(\\p{Alnum}+(\\s+\\p{Alnum}+)*)\\s+([A-Z]{3})([0-9.]*)";

        var pattern = Pattern.compile(regex);
        String input = "Amazon Kindle for kids   USD29.9";

        var matcher = pattern.matcher(input);
        System.out.println(matcher.matches());

        System.out.println("Group count : " + matcher.groupCount());
        System.out.println("Group 0: " + matcher.group(0));
        System.out.println("Group 1: " + matcher.group(1)); // (\\p{Alnum}+(\\s+\\p{Alnum}+)*)
        System.out.println("Group 2: " + matcher.group(2)); // (\\s+\\p{Alnum}+)
        System.out.println("Group 3: " + matcher.group(3)); // ([A-Z]{3})
        System.out.println("Group 4: " + matcher.group(4)); // ([0-9.]*)


        var regex2 = "(?<item>\\p{Alnum}+(\\s+\\p{Alnum}+)*)\\s+(?<currency>[A-Z]{3})(?<price>[0-9.]*)";


        // Using named groups
        System.out.println("********* Using named groups");
        var pattern2 = Pattern.compile(regex2);
        String input2 = "Amazon Kindle for kids   USD29.9";

        var matcher2 = pattern2.matcher(input2);
        System.out.println(matcher2.matches());

        System.out.println("Group count : " + matcher2.groupCount());
        System.out.println("Group 0 - whole    : " + matcher2.group(0));
        System.out.println("Group 1 - item     :" + matcher2.group("item")); // (\\p{Alnum}+(\\s+\\p{Alnum}+)*)
        System.out.println("Group 2 - currency :" + matcher2.group("currency")); // ([A-Z]{3})
        System.out.println("Group 3 - price    :" + matcher2.group("price")); // ([0-9.]*)

    }
}
