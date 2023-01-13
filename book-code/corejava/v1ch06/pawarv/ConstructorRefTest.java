package pawarv;

import java.util.ArrayList;

/* 
 * This program demonstrates the use of constructor reference
 * 
 */
public class ConstructorRefTest {
    public static void main(String[] args) {

        var names = Person.getNames();

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


