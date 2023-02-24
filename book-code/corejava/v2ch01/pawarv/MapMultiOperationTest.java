package pawarv;

import java.util.List;

/*
 * Demonstrates the mapMulti operation on a stream.
 */
public class MapMultiOperationTest {

    public static void main(String[] args) {

        var names = List.of("John", "Paul", "George", "Ringo", "John", "Paul", "John", "Jo", "Jacob");

        // Map names to their lengths
        var nameLengths = names.stream()
                .mapMulti((name, downstream) -> {
                    // Downstream is a Consumer
                    // each name explodes into 1 integers
                    downstream.accept(name.length());           
                }) // Function takes a String (name) and returns an Integer (length)
                .toList(); // Terminal operation

        System.out.println(nameLengths);
        

        // Map names to their lengths
        var nameLengths2 = names.stream()
                .mapMulti((name, downstream) -> {
                    // Downstream is a Consumer
                    // each name explodes into 3 integers
                    downstream.accept(name.length());           
                    downstream.accept(name.length() + 10);
                    downstream.accept(name.length() + 100);
                }) // Function takes a String (name) and returns an Integer (length)
                .toList(); // Terminal operation

        System.out.println(nameLengths2);
    }

}
