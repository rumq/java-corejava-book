package pawarv;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import pawarv.streams.Person;

public class DownstreamCollectorsTest {
    public static void main(String[] args) {

        var persons = List.of(
                new Person("Adam", "US"),
                new Person("Adam", "US"),
                new Person("Bella", "US"),
                new Person("Charlie", "UK"),
                new Person("David", "UK"),
                new Person("Anand", "India"),
                new Person("Brahma", "India"),
                new Person("Mia", "Albania"),
                new Person("Nina", "Albania"));

        // a0) Group by country
        var grouped0 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::country));
        System.out.println("***grouped0 :" + grouped0);

        // a) Get counts for each country
        var grouped = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::country,
                        Collectors.counting()));
        System.out.println("***grouped :" + grouped);

        // a01) Contrast with counting for all
        var grouped01 = persons.stream()
                .collect(Collectors.counting());
        System.out.println("***grouped :" + grouped01);

        // a1) toSet
        var grouped1 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::country,
                        Collectors.toSet()));
        System.out.println("***grouped1 :" + grouped1);

        // b) mapping to name and create a set
        var grouped2 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::country,
                        Collectors.mapping(
                                person -> person.name(),
                                Collectors.toSet())));
        System.out.println("***grouped2 :" + grouped2);

        // c) summingInt
        var grouped3 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::country,
                        Collectors.summingInt(
                                person -> person.name().length())));
        System.out.println("***grouped3 :" + grouped3);

        // d) maxBy
        var grouped4 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::country,
                        Collectors.maxBy(
                                Comparator.comparingInt(p -> p.name().length()))));

        System.out.println("***grouped4 :" + grouped4);

        // e) teeing - count and sum
        var grouped5 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::country,
                        Collectors.teeing(
                                Collectors.counting(),  // 1st downstream collector
                                Collectors.summingInt(  
                                        person -> person.name().length()), // 2nd downstream collector
                                (count, sum) -> "Count: " + count + ", Sum: " + sum))); // combiner
        System.out.println("***grouped5 :" + grouped5);

    }
}
