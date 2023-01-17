package pawarv;

public class ArrayListTest {
    
    public static void main(String[] args) {

        // get a list
        var people = Person.getPeopleList();
        System.out.println("\n****" + people);
        
        // add a new element
        System.out.println(people.get(2));
        people.add(2, new Person("George"));
        System.out.println("\n****" + people);

        // update an element
        people.set(0, new Person("Amanda"));
        System.out.println("\n****" + people);
        
        // remove an element
        people.remove(2);
        System.out.println("\n****" + people);
    }
}
