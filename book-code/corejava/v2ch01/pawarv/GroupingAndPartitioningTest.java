package pawarv;

import java.util.List;
import java.util.stream.Collectors;

import pawarv.streams.Person;

public class GroupingAndPartitioningTest {

    public static void main(String[] args) {

        var names = List.of(
            new Person("Adam", "US"),
            new Person("Bella", "US"),
            new Person("Charlie", "UK"),
            new Person("David", "UK"),
            new Person("Anand", "India"),
            new Person("Brahma", "India"),

            new Person("Stelina", "Albania"),
            // new Person("Mia", "Albania"),
            // new Person("Nina", "Albania"),
            new Person("Ilda", "Albania")
        );
        // a) grouping by lambda as the classifier function
        var grouped = names.stream()
            .collect(Collectors.groupingBy(
                person -> person.country()));
        System.out.println("***grouped :" + grouped);
        System.out.println("***class" + grouped.getClass());
        System.out.println("***keySet" + grouped.keySet());
        System.out.println("***US" + grouped.get("US"));
        System.out.println("***UK" + grouped.get("UK"));
        System.out.println("***India" + grouped.get("India"));
        System.out.println("***Albania" + grouped.get("Albania"));

        // a1) using method reference as the classifier function
        var grouped2 = names.stream()
            .collect(Collectors.groupingBy(
                Person::country)); // classifier function for grouping
        System.out.println("***grouped2 :" + grouped2);

        // b) partitioning by predicate
        var partitioned = names.stream()
            .collect(Collectors.partitioningBy(
                person -> person.country().equals("India")));
        System.out.println("***partitioned :" + partitioned);
        System.out.println("***class" + partitioned.getClass());
        System.out.println("***keySet" + partitioned.keySet());
        System.out.println("***true" + partitioned.get(true));
        System.out.println("***false" + partitioned.get(false));

    }
}
