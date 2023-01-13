package pawarv;

import java.util.Arrays;
import java.util.Comparator;

public class AdvancedComparatorsTest {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Person.getPeopleArray()));

        // Using our own comparator code
        var people1 = Person.getPeopleArray();
        Arrays.sort(people1, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        System.out.println(Arrays.toString(people1));

        // Using the comparator code from helpers in Comparator class
        // comparing method takes a function that extracts a key from a Person object
        // and returns a comparator that compares by that key
        var people2 = Person.getPeopleArray();
        Arrays.sort(people2, Comparator.comparing(Person::getName));
        System.out.println(Arrays.toString(people2));

        // Comparator chaining
        var people3 = Person.getPeopleArray();
        Arrays.sort(people3, Comparator.comparing(Person::getNameLength)
                .thenComparing(Person::getName));

        System.out.println(Arrays.toString(people3));

        // Prepare a list with a null person
        var peopleList = Person.getPeopleList();
        peopleList.add(null);

        // Nulls first
        var people4 = peopleList.toArray(new Person[0]);
        // Uncomment the below to see the exception
        // Arrays.sort(people4, Comparator.comparing(Person::getName));
        Arrays.sort(people4, Comparator.nullsFirst(Comparator.comparing(Person::getName)));
        System.out.println(Arrays.toString(people4));

        // Nulls last
        var people5 = peopleList.toArray(new Person[0]);
        Arrays.sort(people5, Comparator.nullsLast(Comparator.comparing(Person::getName)));
        System.out.println(Arrays.toString(people5));

        // Natural ordering, nulls first
        // Prepare a list with an person with null name
        var peopleList2 = Person.getPeopleList();
        peopleList2.add(new Person(null));
        var people6 = peopleList2.toArray(new Person[0]);
        Arrays.sort(people6, Comparator.comparing(Person::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println(Arrays.toString(people6));

        var people7 = peopleList2.toArray(new Person[0]);
        Arrays.sort(people7, Comparator.comparing(Person::getName, Comparator.nullsFirst(Comparator.reverseOrder())));
        System.out.println(Arrays.toString(people7));
    }

}
