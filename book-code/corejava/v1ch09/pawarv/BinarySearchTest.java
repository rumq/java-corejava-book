package pawarv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        
        var names = List.of("Peter", "Paul", "Mary", "Adam", "Ethan", "Farhan");
        var namesList = new ArrayList<>(names);
        System.out.println(namesList);
        
        Collections.sort(namesList);
        System.out.println(namesList);
        
        // Element found
        System.out.println(Collections.binarySearch(namesList, "Mary"));

        // Element not found
        System.out.println(Collections.binarySearch(namesList, "John"));

        // Add the the element to the list
        namesList.add(4 - 1, "John");
        System.out.println(namesList);

        // Confirm that the element is inserted at the right place.
        Collections.sort(namesList);        
        System.out.println(namesList);

        System.out.println("*** Shuffle the list");
        Collections.shuffle(namesList);
        System.out.println(namesList);

        // binarySearch is unreliable if the list is not sorted
        System.out.println(Collections.binarySearch(namesList, "Mary"));

        // LinkedList
        System.out.println("*** LinkedList");
        var namesList2 = new LinkedList<>(names);
        System.out.println(namesList2);
        System.out.println(Collections.binarySearch(namesList2, "Mary"));


    }
}
