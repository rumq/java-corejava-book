package pawarv;

import java.util.List;
import java.util.Optional;

public class GettingOptionalTest {
    public static void main(String[] args) {
        // Create an Optional with a value
        Optional<String> name = Optional.of("Adam");
        Optional<String> nameEmptyOptional = Optional.empty();

        // orElse - Get a value if present, otherwise return a default value
        System.out.println(nameEmptyOptional.orElse("No name found"));

        // orElseGet - Get the value from a supplier
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
    }
}
