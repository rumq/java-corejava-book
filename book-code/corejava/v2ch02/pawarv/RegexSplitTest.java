package pawarv;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexSplitTest {
    public static void main(String[] args) {


        // Using Pattern
        var colons = Pattern.compile("\\s*:\\s*");
        String[] tokens = colons.split("apple : boy : chocolate : d");
        System.out.println("Number of tokens: " + tokens.length);

        System.out.println("Tokens: ");
        for(String token : tokens){
            System.out.println(token);
        }


        // Using Streams
        System.out.println("********* Using Streams");
        Pattern.compile("\\s*:\\s*")
                .splitAsStream("a : b : c : d")
                .forEach(System.out::println);
    
        // Using Scanner
        System.out.println("********* Using Scanner");
        try (var scanner = new Scanner("a : b : c : d")) {
            scanner.useDelimiter("\\s*:\\s*");
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
        }

        
        
    }
}
