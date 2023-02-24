package pawarv;

import java.util.List;

/*
 * Demonstrates the map operation on a stream.
 * 
 */
public class MapOperationTest {

    public static void main(String[] args) {

        var names = List.of("John", "Paul", "George", "Ringo", "John", "Paul", "John", "Jo", "Jacob");

        // Map names to their lengths
        var nameLengths = names.stream()
                .map(name -> name.length()) // Function takes a String (name) and returns an Integer (length)
                .toList(); // Terminal operation

        System.out.println(nameLengths);

        // Map names to lower case
        var upperCaseNames = names.stream()
                .map(String::toUpperCase) // Function takes a String (name) and returns a String (lower case)
                .toList(); // Terminal operation

        System.out.println(upperCaseNames);

    }
}
