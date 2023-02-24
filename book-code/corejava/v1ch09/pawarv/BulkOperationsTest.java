package pawarv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BulkOperationsTest {
    public static void main(String[] args) {
        
        var names = List.of("Peter", "Paul", "Mary", "Adam", "Ethan", "Farhan");
        var namesList = new ArrayList<>(names);
        System.out.println(namesList);

        // removeAll
        namesList.removeAll(List.of("Peter", "Paul"));
        System.out.println(namesList);

        // retainAll
        namesList.retainAll(List.of("Mary", "Adam"));
        System.out.println(namesList);

        // intersection (using retainAll)
        var pNamesList = new ArrayList<>(List.of("Peter", "Paul", "Pranav"));
        System.out.println("pNameList : " + pNamesList);
        var intersection = new ArrayList<>(names);
        intersection.retainAll(pNamesList);
        System.out.println("Intersection: " + intersection);

        // union (using addAll)
        var union = new ArrayList<>(names);
        union.addAll(pNamesList);
        System.out.println("Union: " + union);

        // Operation on a view
        var vmap = Map.of("Peter", 1, "Paul", 2, "Mary", 3, "Adam", 4, "Ethan", 5, "Farhan", 6);
        var map = new HashMap<>(vmap);
        System.out.println(map);
        var set = Set.of("Peter", "Paul", "Mary");
        map.keySet().removeAll(set);
        System.out.println(map);




        

    }
}
