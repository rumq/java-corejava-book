package pawarv;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Demonstrates the flatMap operation on a stream.
 * 
 */
public class FlatMapOperationComplexTest {
    public static void main(String[] args) {

        var names = List.of("John", "Paul", "George", "Ringo", "John", "Paul", "John", "Jo", "Jacob");

        // FlatMap names to their characters
        var nameCharacters = names.stream()
                .flatMap(name -> name.chars().mapToObj(c -> (char) c)) // Function takes a String (name) and returns a
                                                                       // Stream<Character>
                .toList(); // Terminal operation

        System.out.println(nameCharacters);

        // Shows a break up of the operations

        // .chars() on String returns an IntStream
        IntStream var = "John".chars() ;
        var.forEach(System.out::println);
        
        // .mapToObj() on IntStream returns a Stream<Character>
        Stream<Character> var2 = "John".chars().mapToObj(c -> (char) c);
        var2.forEach(System.out::println);

    }
}
