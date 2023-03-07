package pawarv;

import java.util.ArrayList;
import java.util.List;

public class BasicReduceTest {
    public static void main(String[] args) {

        var numbers = List.of(4,2,1,5);

        // sum
        var sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        var sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum2: " + sum2);

        var sum3 = numbers.stream().reduce((a,b) -> a + b);
        System.out.println("Sum3: " + sum3);

        var list = new ArrayList<String>();
        var sum4 = list.stream().reduce((a,b) -> a + b);
        System.out.println("Sum4: " + sum4);

        list.add("a");
        var sum5 = list.stream().reduce((a,b) -> a + b);
        System.out.println("Sum5: " + sum5);

        // product
        var product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        // max
        var max = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println("Max: " + max);

        // min
        var min = numbers.stream().reduce(0, (a, b) -> a < b ? a : b);
        System.out.println("Min: " + min);

        // count
        var count = numbers.stream().reduce(0, (a, b) -> a + 1, (a, b) -> a + b);
        System.out.println("Count: " + count);
        
        var count2 = numbers.stream().reduce(0, (a,b) -> a + 1);
        System.out.println("Count2: " + count2);

        
    }
}
