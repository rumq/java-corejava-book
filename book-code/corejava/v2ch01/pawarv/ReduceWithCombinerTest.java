package pawarv;

import java.util.ArrayList;

public class ReduceWithCombinerTest {
    public static void main(String[] args) {

        var persons = Person.getNames();
        System.out.println("Persons: " + persons);

        // a)  No combiner
        // Result, identity the type for accumulator are all the same.
        String resultA = persons.stream().reduce(
                "", // identity
                (a, b) -> a + b); // accumulator
        System.out.println("resultA :" + resultA);

        // b) With combiner, same as accumulator
        // accumulator and combiner are the same
        String resultB = persons.stream().reduce(
                "", // identity
                (a, b) -> a + b, // accumulator
                (a, b) -> a + b); // combiner
        System.out.println("resultB :" + resultB);

        // c) With combiner, different from accumulator
        // Result, identity, both inputs of combiner and one input of accumulator are of
        // same type
        int resultC = persons.stream().reduce(
                0, // identity
                (a, b) -> a + b.length(), // accumulator
                (a, b) -> a + b); // combiner

        System.out.println("resultC :" + resultC);

        // d) using collect instead of reduce (compare with b) )
        // Reduce is not generic, so we need to use collect
        var resultD = persons.stream().collect(
                StringBuilder::new, // supplier
                StringBuilder::append, // accumulator
                StringBuilder::append); // combiner
        System.out.println("resultD: " + resultD);

        // e) same as above, but not using method reference
        var resultE = persons.stream().collect(
                StringBuilder::new, // supplier
                (a, b) -> a.append(b), // accumulator
                (a, b) -> a.append(b)); // combiner
        System.out.println("ResultE: " + resultE);

        var list = persons.stream().collect(
                ArrayList::new, // supplier
                ArrayList::add, // accumulator
                ArrayList::addAll); // combiner

        System.out.println("List: " + list);

    }

}
