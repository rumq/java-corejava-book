package pawarv;

import java.util.List;

public class CollectionToArrayTest {
    public static void main(String[] args) {

        // list from array
        String names[] = { "Peter", "Paul", "Mary", "Adam", "Ethan", "Farhan" };
        var namesList = List.of(names);
        System.out.println(namesList);

        // array from list
        System.out.println("** First way");
        var namesArray = namesList.toArray(new String[0]); // Java 8
        for (var name : namesArray) {
            System.out.println(name);
        }

        System.out.println("** Second way");
        var namesArray2 = namesList.toArray(String[]::new);  // Java 11
        for (var name : namesArray2) {
            System.out.println(name);
        }

    }
}
