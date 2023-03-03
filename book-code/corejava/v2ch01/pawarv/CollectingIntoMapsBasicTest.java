package pawarv;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * Demo of Collectors.toMap() method
 * 
 */
public class CollectingIntoMapsBasicTest {
    public static void main(String[] args) {

        var names = List.of("Peter", "Paul", "Mary", "Peter", "Paul", "Mary", "Eve", "Eve", "Eve");

        // a) key mapper, value mapper
        try {
            var nameToCount = names.stream()
                    .distinct() // comment this line to see the exception
                    .collect(Collectors.toMap(
                            name -> name, // key mapper
                            name -> 1)); // value mapper
            System.out.println(nameToCount);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // b) key mapper, value mapper, merge function
        // merge function is called when there are duplicate keys
        var nameToCount2 = names.stream()
                .collect(Collectors.toMap(
                        name -> name, // key mapper
                        name -> 1, // value mapper
                        Integer::sum)); // merge function
        System.out.println(nameToCount2);
        System.out.println(nameToCount2.getClass());

        // c) key mapper, value mapper, merge function, map supplier
        // map supplier is called to create a new map rather than using the default map
        var nameToCount3 = names.stream()
                .collect(Collectors.toMap(
                        name -> name, // key mapper
                        name -> 1, // value mapper
                        Integer::sum, // merge function
                        TreeMap::new)); // map supplier
        System.out.println(nameToCount3);
        System.out.println(nameToCount3.getClass());

    }
}
