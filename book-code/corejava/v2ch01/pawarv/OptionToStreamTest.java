package pawarv;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/*
 * Demonstrates how to convert an Optional to a Stream
 * Then use the stream to print all non-empty optionals
 *
 *  */
public class OptionToStreamTest {
    public static void main(String[] args) {

        // 1. List of optionals
        var optionals = List.of(Optional.of("George"),
                Optional.of("Adam"),
                Optional.empty(),
                Optional.of("John"),
                Optional.of("Doe"),
                Optional.empty());

        // 1a Print all non-empty optionals
        optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

        // 1b Print all non-empty optionals, elegant way
        // flatMap drops all the empty optionals
        optionals.stream()
                .flatMap(Optional::stream)  // Using the `stream` method of Optional
                .forEach(System.out::println);

        // 2. Non optionals with nulls
        var listWithNulls = Arrays.asList("blue", "yellow", null, "red", "green", null);
        // 2a Print all non-null elements
        System.out.println("************* Objects::nonNull *************");
        listWithNulls.stream() 
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        // 2b Print all non-null elements, using flatMap
        System.out.println("************* flatMap *************");
        listWithNulls.stream()
                .flatMap(Stream::ofNullable)  // Stream from a single element, or empty
                .forEach(System.out::println);

    }
}
