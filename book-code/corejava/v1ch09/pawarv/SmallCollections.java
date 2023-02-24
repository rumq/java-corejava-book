package pawarv;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallCollections {

    public static void main(String[] args) {
        
        // Creates an immutable list containing the specified elements.
        var names = List.of("Peter", "Paul", "Mary");
        System.out.println(names);    
        // names.add("Adam"); // throws UnsupportedOperationException

        // Creates an immutable list containing the specified elements (more than 10)
        var integers = List.of(1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9 ,10, 11, 12, 13, 14);
        System.out.println(integers);

        // Creates an immutable set containing the specified elements.
        var friends = Set.of("Peter", "Paul", "Mary");
        System.out.println(friends);
        // friends.add("Adam"); // throws UnsupportedOperationException

        // Creates an immutable map containing the specified key value pairs.
        var counts = Map.of("Peter", 1, "Paul", 2, "Mary", 3);
        System.out.println(counts);
        // counts.put("Adam", 4); // throws UnsupportedOperationException

        // Creates an immutable map containing values from the specified entries.
        var counts2 = Map.ofEntries(
            Map.entry("Peter", 1),
            Map.entry("Paul", 2),
            Map.entry("Mary", 3)
        );
        System.out.println(counts2);

        // Returns an immutable list containing n copies of the specified object.
        var list = Collections.nCopies(10, 0);
        System.out.println(list);
    }

    
    
}
