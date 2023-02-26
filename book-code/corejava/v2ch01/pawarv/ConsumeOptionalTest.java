package pawarv;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsumeOptionalTest {
    public static void main(String[] args) {

        // Create an Optional with a value
        Optional<String> name = Optional.of("Adam");
        System.out.println(name.isPresent());
        System.out.println(name.isEmpty());
        System.out.println(name.get());
        System.out.println(name.orElse("No name found"));

        // Create an Optional with a null value
        // Optional<String> nameIsNull = Optional.ofNullable(null);
        Optional<String> nameEmptyOptional = Optional.empty();
        System.out.println(nameEmptyOptional.isPresent());
        System.out.println(nameEmptyOptional.isEmpty());
        // System.out.println(name2.get());
        if (nameEmptyOptional.isPresent()) {
            System.out.println(nameEmptyOptional.get());
        }

        // orElse
        System.out.println(nameEmptyOptional.orElse("No name found"));

        // orElseGet
        var names = List.of("Peter", "Paul", "Mary", "John", "Paul", "Paul", "Paul");
        var extractedName = nameEmptyOptional.orElseGet( // orElseGet takes a Supplier
                () -> names.get(
                        (int) (Math.random() * names.size())));
        System.out.println(extractedName);

        // orElseThrow
        try {
            var extractedName2 = nameEmptyOptional.orElseThrow( // orElseThrow takes a Supplier
                    () -> new RuntimeException("Exception caught - No name found"));
            System.out.println(extractedName2);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // ifPresent
        var nameList = new ArrayList<>();
        name.ifPresent(n -> System.out.println(n)); // ifPresent takes a Consumer
        name.ifPresent(n -> nameList.add(n)); // ifPresent takes a Consumer, so we can add to a list
        name.ifPresent(nameList::add); // same as above
        System.out.println(nameList);
        nameEmptyOptional.ifPresent(n -> System.out.println(n)); // no output

        // ifPresentOrElse
        name.ifPresentOrElse(n -> System.out.println(n), () -> System.out.println("No name found"));
        nameEmptyOptional.ifPresentOrElse(n -> System.out.println(n), () -> System.out.println("No name found"));

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

        nameEmptyOptional.or(
            () -> Optional.of("No name found"))
            .ifPresent(System.out::println);

    }
}
