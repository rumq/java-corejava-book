package pawarv;

import java.util.ArrayList;

public class PredicateTest {
    public static void main(String[] args) {
        
        var list = new ArrayList<String>();

        list.add("Amitabh");
        list.add("Bachan");
        list.add("Jaya");
        list.add("Abhi");

        System.out.println("Original : " + list);
        
        list.removeIf(s -> s.length() < 6);

        System.out.println("After removal :" + list);

    }
}
