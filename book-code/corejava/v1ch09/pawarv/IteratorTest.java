package pawarv;

public class IteratorTest {
    public static void main(String[] args) {

        System.out.println("***************** List");
        var people = Person.getSortedNames();
        System.out.println(people);

        System.out.println("***************** forEachRemaining() method");
        // forEachRemaining() method
        var iterator = people.iterator();
        iterator.forEachRemaining(System.out::println);
        // throws NoSuchElementException
        // iterator.next();
        iterator.forEachRemaining(System.out::println); // no output

        System.out.println("***************** hasNext() and next() methods");
        // hasNext() and next() methods
        var iterator2 = people.iterator();
        while (iterator2.hasNext()) {
            String str = iterator2.next();
            System.out.println(str);
        }

        System.out.println("Printing people");
        System.out.println(people);
        var iterator4 = people.iterator();

        iterator4.next();
        iterator4.remove();                
        iterator4.next();
        iterator4.remove();                
        System.out.println("*******************Today");
        while (iterator4.hasNext()) {
            String str = iterator4.next();
            System.out.println(str);
        }
        System.out.println(people);
        System.out.println(people.size());

        // System.out.println("***************** remove() method");
        // // remove() method
        // var iterator3 = people.iterator();
        // iterator3.next();
        // iterator3.remove();
        // System.out.println(people);


    }
}
