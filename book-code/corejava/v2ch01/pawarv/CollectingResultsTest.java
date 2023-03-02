package pawarv;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectingResultsTest {

    public static void main(String[] args) {

        var list = List.of("blue", "yellow", "red", "green", "blue");

        // iterator (old fashioned)
        System.out.println("************* iterator *************");
        var iterator = list.stream()
                .iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // forEach
        list.stream()
                .forEach(System.out::println);

        // toArray
        System.out.println("************* toArray *************");
        var array = list.stream()
                .toArray(String[]::new);
        for (var s : array) {
            System.out.println(s);
        }

        // toList
        System.out.println("************* toList *************");
        var list2 = list.stream()
                .toList();
        System.out.println(list2);

        // collect Collectors.toList
        System.out.println("************* Collectors.toList *************");
        var list3 = list.stream()
                .collect(Collectors.toList());
        System.out.println(list3);

        // collect Collectors.toSet
        System.out.println("************* toSet *************");
        var set = list.stream()
                .collect(Collectors.toSet());
        System.out.println(set);

        // collect to a TreeSet
        System.out.println("************* toCollection Treeset*************");
        var treeSet = list.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);

        // collect to a String
        System.out.println("************* toCollection String*************");
        var string = list.stream()
                .collect(Collectors.joining(", "));
        System.out.println(string);

        // collect to summary statistics
        System.out.println("************* toCollection summary statistics*************");
        var summary = list.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(summary);
        System.out.println("Average length: " + summary.getAverage());
        System.out.println("Max length: " + summary.getMax());
        System.out.println("Min length: " + summary.getMin());
        System.out.println("Total length: " + summary.getSum());
        System.out.println("Count: " + summary.getCount());

    }
}
