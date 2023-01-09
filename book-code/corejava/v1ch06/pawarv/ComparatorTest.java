package pawarv;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {

        String[] friends = { "Peter", "Paul", "Mary" };
        Arrays.sort(friends, new LengthComparator());

        for (String name : friends)
            System.out.println(name);

        System.out.println("*********** Using anonymous class");     
        Arrays.sort(friends, new Comparator<String>() {
            public int compare(String first, String second) {
                return first.length() - second.length();
            }
        });

        for (String name : friends)
            System.out.println(name);

    }
}

class LengthComparator implements Comparator<String> {
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}