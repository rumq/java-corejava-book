package pawarv;

import java.util.ArrayList;

/* 
 * This program demonstrates the use of constructor reference
 * 
 */
public class ConstructorRefTest {
    public static void main(String[] args) {

        var names = new ArrayList<String>();
        names.add("Peter");
        names.add("Paul");
        names.add("Mary");

        // Constructor reference        
        var people = names.stream().map(Person::new).toList();
        System.out.println(people);

        //  The toArray method invokes this constructor to obtain an array of the correct type. 
        // Then it fills and returns the array.
        Person[] peopleArray = names.stream().map(Person::new).toArray(Person[]::new);
        for (Person p : peopleArray) {
            System.out.println(p);
        }
    }


}

class Person {
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}
