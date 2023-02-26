package pawarv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SimpleReductionsTest {
        public static void main(String[] args) {

                // count
                var names = List.of("Peter", "Paul", "Mary", "John", "Paul", "Paul", "Paul");
                var namesList = new ArrayList<>(names);
                long count = namesList
                                .stream()
                                // .filter(name -> name.length() < 5)
                                .filter(name -> name.startsWith("P"))
                                .count();
                System.out.println("Count: " + count);

                // min
                var min = namesList
                                .stream()
                                .filter(name -> name.length() < 2) // Uncomment to see the output of orElse
                                .min((s1, s2) -> s1.length() - s2.length());
                System.out.println("Min: " + min);
                System.out.println(min.orElse("No name found"));

                // max
                var max = namesList
                                .stream()
                                // .filter(name -> name.length() < 2) // Uncomment to see the output of orElse
                                .max(Comparator.comparing(String::length));
                System.out.println("Max: " + max);
                System.out.println(max.orElse("No name found"));

                // Using a Stream of random numbers
                int integer = 1000;
                var thousandRandomNumbers = Stream
                                .generate(Math::random)
                                .map(n -> (int) (n * integer))
                                .limit(integer)
                                .toList();

                // count
                count = thousandRandomNumbers
                                .stream()
                                // .filter(n -> n < 1000)
                                .count();
                System.out.println("Count: " + count);

                // min
                var minInteger = thousandRandomNumbers
                                .stream()
                                .filter(n -> n > 50 && n < 1000)
                                .min(Integer::compare);
                System.out.println("Min integer: " + minInteger.get());

                // sum
                var sum = thousandRandomNumbers
                                .stream()
                                .filter(n -> n > 50 && n < 1000)
                                .mapToInt(Integer::intValue)
                                .sum();
                System.out.println("Sum: " + sum);

                // findFirst
                var first = thousandRandomNumbers
                                .stream()
                                // .filter(n -> n >2000)
                                .findFirst();
                System.out.println("First: " + first);
                System.out.println(first.orElse(-1));

                // findAny
                var any = thousandRandomNumbers
                                .stream()
                                .parallel() // uncomment to see that it's different from findFirst
                                .findAny();
                System.out.println("Any: " + any);

                // anyMatch
                var anyMatch = thousandRandomNumbers
                                .stream()
                                // .anyMatch(n -> n == 1000);
                                .anyMatch(n -> n == 3);
                System.out.println("AnyMatch: " + anyMatch);

                // allMatch
                var allMatch = thousandRandomNumbers
                                .stream()
                                .allMatch(n -> n < 5);
                // .allMatch(n -> n > 1000);
                System.out.println("AllMatch: " + allMatch);

                // noneMatch
                var noneMatch = thousandRandomNumbers
                                .stream()
                                .noneMatch(n -> n < 1000);
                                // .noneMatch(n -> n == 3);
                System.out.println("NoneMatch: " + noneMatch);

        }
}
