package pawarv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * This program demonstrates the use of checked views.
 * 
 */
public class CheckedViewsTest {
    public static void main(String[] args) {
        
        // Create a list of names
        var names = List.of("Peter", "Paul", "Mary", "Adam", "Ethan", "Farhan");
        var namesList = new ArrayList<>(names);
        System.out.println(namesList);

        // Can assign to a List variable that doesn't specify the type of elements
        ArrayList fakeNames = namesList;

        // Can add an element of the wrong type to the list
        fakeNames.add(123);
        
        System.out.println(fakeNames);
        // namesList now also contains an Integer element
        System.out.println(namesList);

        // But, will throw a Runtime error (ClassCastException) when accessed
        // for (var element : namesList) {            
        //     System.out.println(element.toLowerCase());
        // }
        // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.


        // Prevent this by using a checked view
        var nameList2 = new ArrayList<>(names);
        var checkedNames = Collections.checkedList(nameList2, String.class);   
             
        System.out.println(checkedNames);
        checkedNames.add("John");
        // checkedNames.add(123); // compile-time error

        // ArrayList fakeNames2 = checkedNames;

        



        
    }
}
