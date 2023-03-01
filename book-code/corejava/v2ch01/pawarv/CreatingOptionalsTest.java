package pawarv;

import java.util.Optional;

public class CreatingOptionalsTest {

    public static void main(String[] args) {
        // Create an Optional with a value
        Optional<String> name = Optional.of("Adam");
        System.out.println(name.isPresent()); // true
        System.out.println(name.isEmpty()); // false
        System.out.println(name.get());  // Adam
        System.out.println(name.orElse("No name found"));

        // Create an Optional with a null value        
        Optional<String> nameEmptyOptional = Optional.empty();
        System.out.println(nameEmptyOptional.isPresent()); // false
        System.out.println(nameEmptyOptional.isEmpty()); // true
        // System.out.println(name2.get());
        // Can do this, but it's no better than checking for null;
        if (nameEmptyOptional.isPresent()) {
            System.out.println(nameEmptyOptional.get());
        }

        // `ofNullable` - Can take a null value (`of` can't)
        // Optional.of(null); // Throws a NullPointerException
        Optional<String> nameIsNull = Optional.ofNullable(null);
        System.out.println(nameIsNull.isPresent()); // false

        // Or it can take a non-null value
        Optional<String> nameIsNotNull = Optional.ofNullable("Adam");
        System.out.println(nameIsNotNull.isPresent()); // true

        // Wrap return values from a method
        // Call a method that returns an Optional
        Optional<String> nameFromMethod = getOptionalName("Adam");
        System.out.println(nameFromMethod.isPresent()); // true
        System.out.println(nameFromMethod.get()); // Adam

        // Call a method that returns an Optional
        Optional<String> nameFromMethod2 = getOptionalName(null);
        System.out.println(nameFromMethod2.isPresent()); // false
        System.out.println(nameFromMethod2.orElse("No name found"));


    }

    // A method that returns an Optional
    public static Optional<String> getOptionalName(String name) {
        if (name == null) {
            return Optional.empty();
        } else {
            return Optional.of(name);
        }        
    }

}
