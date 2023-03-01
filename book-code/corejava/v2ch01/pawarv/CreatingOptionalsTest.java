package pawarv;

import java.util.Optional;

public class CreatingOptionalsTest {

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
        // Can do this, but it's no better than checking for null;
        if (nameEmptyOptional.isPresent()) {
            System.out.println(nameEmptyOptional.get());
        }

    }

}
