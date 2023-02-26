package pawarv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class OtherStreamOperationsTest {
    public static void main(String[] args) {

        // List of 20 integers 0 to 9
        var list = Stream
                .generate(Math::random)
                .map(n -> (int) (n * 10))
                .limit(20)
                .toList();

        System.out.println("Random list of 20 :" + list);

        // Effect of using distinct on the above
        var distinctList1 = list
                .stream()
                .distinct()
                .toList();
        System.out.println("Distinct list 1 : " + distinctList1);

        // Could have just added as one more operation.
        var distinctList2 = Stream
                .generate(Math::random)
                .map(n -> (int) (n * 10))
                .limit(100)
                .distinct() //
                .toList();
        System.out.println("Distinct list 2 : " + distinctList2);

        // Sorted on natural order
        var sorted = list
                .stream()
                .sorted()
                .toList();
        System.out.println("Sorted list :" + sorted);

        // Sorted using a comparator
        var names = List.of("John", "Paul", "George", "Ringo", "John", "Paul", "John", "Jo", "Jacob");
        var namesList = new ArrayList<>(names);
        var sortedNames = namesList
                .stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
        System.out.println("Sorted Names " + sortedNames);

        // reverse sorted & peek
        var namesList2 = new ArrayList<>(names);
        var sortedNames2 = namesList
                .stream()
                .peek(e -> System.out.println("Peeking before: " + e))
                .sorted(Comparator.comparing(String::length).reversed())
                .peek(e -> System.out.println("Peeking after : " + e))
                .peek(x -> {
                    return;
                })
                .toList();
        System.out.println("Sorted Names " + sortedNames2);

    }

}
