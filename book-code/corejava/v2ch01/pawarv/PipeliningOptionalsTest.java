package pawarv;

import java.util.ArrayList;
import java.util.Optional;

public class PipeliningOptionalsTest {
    public static void main(String[] args) {

        // Create an Optional with a value
        Optional<String> name = Optional.of("Adam");
        Optional<String> nameEmptyOptional = Optional.empty();
        var nameList = new ArrayList<>();

        // map
        // transform the value and return a new Optional (different from map in Stream)
        name
                .map(String::toUpperCase) // map takes a Function, returns a new Optional
                .ifPresent(System.out::println);
        name
                .map(String::length)
                .ifPresent(System.out::println);
        name
                .map(n -> n + " Grant")
                .ifPresent(System.out::println);
        name
                .map(n -> n + " Grant")
                .map(nameList::add);
        System.out.println(nameList);

        System.out.println("Nothing happens if option has no value");
        nameEmptyOptional
                .map(String::toUpperCase) // map takes a Function, returns a new Optional
                .ifPresent(System.out::println);

        // filter
        // filter the value and return a new Optional
        name
                .filter(n -> n.length() > 3) // filter takes a Predicate.
                .ifPresent(System.out::println);

        // filter
        // returns nothing if the value does not match the filter
        name
                .filter(n -> n.length() > 8) // filter takes a Predicate.
                .ifPresent(System.out::println);

        // or
        // If a value is present, returns an Optional describing the value,
        // otherwise returns an Optional produced by the supplying function.
        // Note the difference between or which returns an Optional,
        // and orElse, which returns the value
        name.or(
                () -> Optional.of("No name found"))
                .ifPresent(System.out::println);

        Optional<String> firstOptional = name.stream().filter(n -> n.length() < 3).findFirst();
        Optional<String> secondOptional = name.stream().filter(n -> n.length() < 3).findAny();
        nameEmptyOptional.or(() -> firstOptional)
                .or(() -> Optional.of("Last optional"))
                .or(() -> secondOptional)
                .ifPresent(System.out::println);

    }
}
