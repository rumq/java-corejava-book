package pawarv;

import java.util.List;
import java.util.Set;

public class UnmodifiableCollectionsTest {
    public static void main(String[] args) {
    
    // set
    var unmodifiableSet = Set.of("Mary", "had", "a", "little", "lamb");
    System.out.println(unmodifiableSet);
    // uncomment this line to see the exception
    // unmodifiableSet.add("Mary2");


    // list
    var unmodifiableList = List.of("Mary", "had", "a", "little", "lamb");
    System.out.println(unmodifiableList);
    // uncomment this line to see the exception
    unmodifiableList.add("Mary2");
    

    }
}
