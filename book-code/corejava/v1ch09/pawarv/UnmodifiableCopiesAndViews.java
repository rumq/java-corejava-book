package pawarv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UnmodifiableCopiesAndViews {
    public static void main(String[] args) {
        
        ArrayList<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Paul");
        names.add("Mary");
        System.out.println("names :" + names);

        // ** Copies 

        // Returns an unmodifiable copy of the specified list.
        var copiedNames  = List.copyOf(names);
        System.out.println("copiedNames :" + copiedNames);
        // copiedNames.add("Adam"); // throws UnsupportedOperationException

        names.add("Ethan"); // this will NOT be reflected in copiedNames
        System.out.println("copiedNames :" + copiedNames);
        System.out.println("names :" + names);
    


        // ** Views

        // Returns an unmodifiable view of the specified list.
        var listView = Collections.unmodifiableList(names);

        System.out.println("listView :" + listView);
        listView.add("Adam"); // throws UnsupportedOperationException

        names.add("Farhan"); // this will BE reflected in listView    
        // System.out.println("listView :" + listView);


        // Returns an unmodifiable view of the specified set.
        var unmodifiableNames2 = Collections.unmodifiableSet(Set.of("Peter", "Paul", "Mary"));
        System.out.println(unmodifiableNames2);
        // unmodifiableNames2.add("Adam"); // throws UnsupportedOperationException

        
    }
}
