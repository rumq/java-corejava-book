package pawarv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class SubrangesTest {
    
    public static void main(String[] args) {
        

        // ** List
        var names = List.of("Peter", "Paul", "Mary", "Adam", "Ethan", "Farhan");

        // Creates a new ArrayList containing the elements of the specified collection.        
        // So this is a copy of the original list that we can modify.
        var namesList = new ArrayList<>(names);
        System.out.println(namesList);

        // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
        var subList = namesList.subList(1, 4); // 1 is inclusive, 4 is exclusive
        System.out.println(subList);

        // Clears the specified subList, which will also clear the corresponding elements in the original list.
        subList.clear();
        System.out.println(namesList);

        // ** SortedSet
        var namesSet = new TreeSet<>(names);
        System.out.println("namesSet : " + namesSet);

        // Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.
        var subSet = namesSet.subSet("Ethan", "Peter"); // "Ethan" is inclusive, "Peter" is exclusive
        
        System.out.println("subSet" + subSet);

        // HeadSet
        var headSet = namesSet.headSet("Ethan"); // "Ethan" is exclusive
        System.out.println("headSet" + headSet);

        // TailSet
        var tailSet = namesSet.tailSet("Ethan"); // "Ethan" is inclusive
        System.out.println("tailSet" + tailSet);

        // ** Map
        var namesMap = Map.of("Andy", 1, "Barbara", 2, "Cindy", 3, "David", 4, "Ethan", 5, "Farhan", 6);

        var treeMap = new TreeMap<>(namesMap);
        System.out.println("treeMap : " + treeMap);

        // Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.
        var subMap = treeMap.subMap("Cindy", "Ethan"); // "Cindy" is inclusive, "Ethan" is exclusive
        System.out.println("subMap" + subMap);

        // HeadMap
        var headMap = treeMap.headMap("Ethan"); // "Ethan" is exclusive
        System.out.println("headMap" + headMap);

        // TailMap
        var tailMap = treeMap.tailMap("Ethan"); // "Ethan" is inclusive
        System.out.println("tailMap" + tailMap);


        

    }
}
