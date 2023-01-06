package pawarv;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        
        var list = new ArrayList<String>();

        list.add("Amitabh");
        list.add("Bachan");
        list.add("Jaya");
        list.add("Abhi");

        System.out.println("Original : " + list);
        
        list.removeIf(s -> s.length() < 5);
        System.out.println("After removal round 1 :" + list);


        // Use of Predicate.and()
        Predicate<String> p1 = s -> s.length() > 5;
        Predicate<String> p2 = s -> s.startsWith("A");

        list.removeIf(p1.and(p2));
        System.out.println("After removal round 2 :" + list);

        list.removeIf(p1.or(p2));
        System.out.println("After removal round 3 :" + list);

    }
}
