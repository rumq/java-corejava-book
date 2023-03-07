package pawarv;

import java.util.List;
import java.util.stream.Collectors;

public class DifferentWaysOfSumming {

    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5);
        

        // a) reduce with identity and accumulator       
        int sumA = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sumA: " + sumA);

        // b) reduce with identity, accumulator (method reference)
        int sumB = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sumB: " + sumB);

        // c) reduce with accumulator
        int sumC = numbers.stream().reduce((a, b) -> a + b).get();
        System.out.println("sumC: " + sumC);
        
        // d) reduce with identity, accumulator, combiner
        int sumD = numbers.stream().reduce(0, (a, b) -> a + b, (a, b) -> a + b);
        System.out.println("sumD: " + sumD);
        
        // e) mapToInt, sum
        int sumE = numbers.stream().mapToInt(Integer::intValue).sum();        
        System.out.println("sumE: " + sumE);

        // f) collect summingInt
        int sumF = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("sumF: " + sumF);

        // g) collect summingInt with lambda
        int sumG = numbers.stream().collect(Collectors.summingInt(i -> i));
        System.out.println("sumG: " + sumG);
    }

}

