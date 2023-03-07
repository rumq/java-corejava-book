package pawarv;

import static java.util.stream.Collectors.*;
import pawarv.streams.Person;

public class DownstreamCollectorsTeeingTest {

        public static void main(String[] args) {
                var persons = Person.getPersons();

                System.out.println("**** persons :" + persons);
                // a0) teeing - count and sum
                var grouped0 = persons.stream()
                                .collect(teeing(counting(),
                                                summingInt(person -> person.name().length()),
                                                (count, sum) -> "Count: " + count + ", Sum: " + sum));
                System.out.println("***grouped0 :" + grouped0);

                // e) Grouping and teeing - count and sum
                var grouped5 = persons.stream()
                                .collect(groupingBy(
                                                Person::country, // classifier
                                                teeing(
                                                                counting(), // 1st downstream collector
                                                                summingInt(
                                                                                person -> person.name().length()), // 2nd
                                                                                                                   // downstream
                                                                                                                   // collector
                                                                (count, sum) -> "Count: " + count + ", Sum: " + sum))); // combiner
                System.out.println("***grouped5 :" + grouped5);
                // f) teeing twice
                var grouped6 = persons.stream()
                                .collect(groupingBy(
                                                Person::country, // classifier
                                                teeing(
                                                                teeing( // teeing inside teeing
                                                                                averagingInt(person -> person.name()
                                                                                                .length()), //
                                                                                // counting(), // 1st downstream
                                                                                // collector
                                                                                // 2nd downstream collector
                                                                                counting(), // 2nd downstream collector
                                                                                (count1, max) -> "Average size of name :"
                                                                                                + count1
                                                                                                + ", Number of people : "
                                                                                                + max) // combiner
                                                                ,
                                                                summingInt( //
                                                                                person -> person.name().length()),
                                                                (first, second) -> first + ", Sum of name lengths: "
                                                                                + second))); // combiner
                System.out.println("***grouped6 :" + grouped6);

        }

}
