package pawarv;

import java.util.TreeSet;

/*
 * This program demonstrates the use of a tree set.
 * 
 */
public class TreeSetBasicTest {
    public static void main(String[] args) {

        var sorter = new TreeSet<String>();
        sorter.add("Bob");
        sorter.add("Carl");
        sorter.add("Amy");

        // print the sorted set
        for (String s : sorter)
            System.out.println(s);
    }
}
