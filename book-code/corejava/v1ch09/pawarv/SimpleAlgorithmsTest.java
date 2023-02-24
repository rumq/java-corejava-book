package pawarv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleAlgorithmsTest {
    public static void main(String[] args) {

        // Create a list
        var names = List.of("Peter", "Paul", "Mary", "Adam", "Ethan", "Farhan");
        var namesList = new ArrayList<>(names);
        System.out.println(namesList);

        // min
        var min = Collections.min(namesList);
        System.out.println(min);

        // max
        var max = Collections.max(namesList);
        System.out.println(max);

        // show the sorted list
        Collections.sort(namesList);
        System.out.println(namesList);

        // fill
        var copiedList = new ArrayList<String>(names);
        System.out.println(copiedList);
        Collections.fill(copiedList, "John");
        System.out.println(copiedList);

        // Copy
        Collections.copy(copiedList, namesList);
        System.out.println(copiedList);

        // addAll
        Collections.addAll(copiedList, "George", "Ringo");
        System.out.println(copiedList);

        // replaceAll
        Collections.replaceAll(copiedList, "Ringo", "Paul");
        System.out.println(copiedList);

        // indexOfSubList
        var subList = namesList.subList(3, 4);
        var index = Collections.indexOfSubList(namesList, subList);
        System.out.println(index);

        // Swap
        Collections.swap(namesList, 0, 1);
        System.out.println(namesList);

        // Reverse
        Collections.reverse(namesList);
        System.out.println(namesList);

        // Rotate
        Collections.rotate(namesList, 2);
        System.out.println(namesList);

        // frequency
        var frequency = Collections.frequency(namesList, "Adam");
        System.out.println(frequency);
        namesList.add("Adam");
        frequency = Collections.frequency(namesList, "Adam");
        System.out.println(frequency);

        // disjoint
        var disjoint = Collections.disjoint(namesList, copiedList);
        System.out.println(disjoint);

        disjoint = Collections.disjoint(namesList, List.of("Test", "Test2"));
        System.out.println(disjoint);

        // removeIf
        namesList.removeIf(s -> s.length() > 4);
        System.out.println(namesList);

        // replaceAll
        namesList.replaceAll(String::toUpperCase);
        System.out.println(namesList);

    }
}
