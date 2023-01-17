package pawarv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * This program demonstrates the use of a hash set.
 * 
 */
public class HashSetTest {
    public static void main(String[] args) {

        var set = new HashSet<String>();
        set.add("Mary");
        set.add("had");
        set.add("a");
        set.add("little");
        set.add("lamb");
        set.add("Mary");

        var list = new ArrayList<String>();
        list.add("Mary");
        list.add("had");
        list.add("a");
        list.add("little");
        list.add("lamb");
        list.add("Mary");

        System.out.println(set);
        System.out.println(list);

        System.out.println(set.size());
        System.out.println(set.contains("Mary"));
        System.out.println(set.contains("Mary1"));

    }
}
