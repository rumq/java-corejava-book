package pawarv;

import java.util.Arrays;

public class MoreSimpleReductionsTest {
    public static void main(String[] args) {
        int[] values = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };
        System.out.printf("Original values: %s%n", Arrays.toString(values));
        System.out.printf("Sum of values: %d%n", Arrays.stream(values).sum());
        System.out.printf("Sum of squares: %d%n", Arrays.stream(values).map(x -> x * x).sum());
        System.out.printf("Sum of cubes: %d%n", Arrays.stream(values).map(x -> x * x * x).sum());
        System.out.printf("Sum of squares of even values: %d%n", Arrays.stream(values).filter(x -> x % 2 == 0).map(x -> x * x).sum());
        System.out.printf("Sum of cubes of odd values: %d%n", Arrays.stream(values).filter(x -> x % 2 != 0).map(x -> x * x * x).sum());
        System.out.printf("Sum of squares of odd values: %d%n", Arrays.stream(values).filter(x -> x % 2 != 0).map(x -> x * x).sum());
        System.out.printf("Sum of cubes of even values: %d%n", Arrays.stream(values).filter(x -> x % 2 == 0).map(x -> x * x * x).sum());
        
    }
}
