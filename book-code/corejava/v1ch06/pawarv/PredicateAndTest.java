package pawarv;

import java.util.function.Predicate;

public class PredicateAndTest {
  public static void main(String[] args) {
    Predicate<Integer> isPositive = x -> x > 0;
    Predicate<Integer> isEven = x -> x % 2 == 0;

    Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);

    System.out.println(isPositiveAndEven.test(2));  // true
    System.out.println(isPositiveAndEven.test(-2));  // false
    System.out.println(isPositiveAndEven.test(0));  // false
  }
}
