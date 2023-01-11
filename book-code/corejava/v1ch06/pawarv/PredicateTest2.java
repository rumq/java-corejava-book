package pawarv;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateTest2 {
    public static void main(String[] args) {
        var list = new ArrayList<String>();

        list.add("Alia");
        list.add("Bob");
        list.add("Carl");
        list.add("Diana");
        list.add("Ethan");
        list.add("Ada");
        list.add("Adarsh");

        System.out.println("Original : " + list);

        list.removeIf(s -> s.equals("Alia"));

        System.out.println("After removal round 1 :" + list);

        list.removeIf(s -> s.startsWith("B"));

        System.out.println("After removal round 2 :" + list);

        list.removeIf(s -> s.contains("Ada"));

        System.out.println("After removal round 3 :" + list);

     
        Predicate<String> p1 = s -> s.length() > 3;

        Predicate<String> p2 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        };

        Predicate<String> p3 = new PredicateLength();
        

        list.removeIf(p3);

        System.out.println("After removal round 4 :" + list);


    }

    
}

class PredicateLength implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.length() > 3;
    }
}