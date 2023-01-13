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

        System.out.println("***************** remove() method");
        // remove() method
        var iterator3 = people.iterator();
        iterator3.next();
        iterator3.remove();
        System.out.println(people);


    }
}
