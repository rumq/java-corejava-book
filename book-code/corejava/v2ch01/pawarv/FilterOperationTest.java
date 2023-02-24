package pawarv;

import java.util.List;

/*
 * Demonstrates the filter operation on a stream.
 * 
 */
public class FilterOperationTest {

    public static void main(String[] args) {

        var names = List.of("John", "Paul", "George", "Ringo", "John", "Paul", "John", "Jo", "Jacob");

        // Filter names that start with J and have length > 3
        var filteredNames = names.stream()
                .filter(name -> name.startsWith("J")) // Predicate takes a String (name) and returns a boolean
                .filter(name -> name.length() > 3)
                .toList(); // Terminal operation

        System.out.println(filteredNames);

    }

}
