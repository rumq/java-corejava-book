package pawarv;

import java.util.List;

/* 
 *  Demonstrates the flatMap operation on a stream.
 */
public class FlatMapOperationSimpleTest {
    public static void main(String[] args) {
        var namesAndPlaces = List.of(List.of("John", "Paul", "George", "Ringo"),
                List.of("London", "Liverpool", "Liverpool", "Liverpool"));

        // FlatMap names to their characters
        var namesAndPlacesList = namesAndPlaces.stream()
                .flatMap(list -> list.stream()) // function takes a list and returns a stream
                .toList(); // Terminal operation

        System.out.println(namesAndPlacesList);

    }
}
