package pawarv;

/*
 * This program demonstrates the use of a list iterator.
 * 
 */
public class ListIteratorTest {
   
    public static void main(String[] args) {
        
        // get a list iterator
        var people = Person.getSortedNames();
        var iterator = people.listIterator();
        iterator.next();
        iterator.add("Tom");
        System.out.println(people);
        iterator.next();
        iterator.add("Sam");
        System.out.println(people);
        iterator.next();
        iterator.add("Zuckerberg"   );
        System.out.println(people);
        iterator.next();   // comment this line 
        // iterator.previous(); // uncomment this 
        iterator.remove();
        System.out.println(people);
        iterator.next();
        iterator.next();
        iterator.remove();
        System.out.println(people);

    }
}
