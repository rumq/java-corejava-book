package pawarv;

import java.util.ArrayList;
import java.util.Optional;

public class ConsumeOptionalTest {
        public static void main(String[] args) {

                // Create an Optional with a value
                Optional<String> name = Optional.of("Adam");
                Optional<String> nameEmptyOptional = Optional.empty();

                // ifPresent
                var nameList = new ArrayList<>();
                name.ifPresent(n -> System.out.println(n)); // ifPresent takes a Consumer
                name.ifPresent(n -> nameList.add(n)); // ifPresent takes a Consumer, so we can add to a list
                name.ifPresent(nameList::add); // same as above
                System.out.println(nameList);
                nameEmptyOptional.ifPresent(n -> System.out.println(n)); // no output

                // ifPresentOrElse
                name.ifPresentOrElse(n -> System.out.println(n), () -> System.out.println("No name found"));
                nameEmptyOptional.ifPresentOrElse(n -> System.out.println(n),
                                () -> System.out.println("No name found"));

        }
}
