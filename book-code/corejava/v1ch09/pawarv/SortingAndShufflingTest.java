package pawarv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAndShufflingTest {

    public static void main(String[] args) {

        var names = List.of("Peter", "Paul", "Mary", "Adam", "Ethan", "Farhan");

        var namesList = new ArrayList<>(names);
        System.out.println(namesList);

        Collections.shuffle(namesList);
        System.out.println(namesList);

        Collections.sort(namesList);
        System.out.println(namesList);

    }

}
