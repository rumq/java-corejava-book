package pawarv;

public class GenericUtilityMethodsTest {
    public static void main(String[] args) {
        
        System.out.println("***************** List");
        var people = Person.getSortedNames();
        System.out.println(people);
        

        System.out.println("size()=" + people.size());
        System.out.println("isEmpty()=" + people.isEmpty());
        System.out.println("contains(\"John\")= " + people.contains("John"));
        System.out.println("contains(\"Alia\")= " + people.contains("Alia"));

        System.out.println("***************** remove(\"Alia\") method");
        var people2 = Person.getSortedNames();
        people2.remove("Alia");
        System.out.println(people2);

        System.out.println("***************** containsAll() method");
        System.out.println(people.containsAll(people2));

        System.out.println("***************** add() method");
        people2.add("John");
        System.out.println(people2);
        System.out.println(people.containsAll(people2));

        System.out.println("***************** addAll() method");
        people2.addAll(people);
        System.out.println(people2);

        System.out.println("***************** removeAll() method");
        people2.removeAll(people);
        System.out.println(people2);

        System.out.println("***************** retainAll() method");
        people.retainAll(people);
        System.out.println(people);
        people.retainAll(people2);
        System.out.println(people);

        System.out.println("***************** clear() method");
        var people3 = Person.getSortedNames();
        people3.clear();
        System.out.println(people3);

        System.out.println("***************** toArray() method");
        var people4 = Person.getSortedNames();
        var peopleArray = people4.toArray();
        System.out.println(peopleArray);
        for (var person : peopleArray) {
            System.out.println(person);
        }

        System.out.println("***************** toArray(T[]) method");
        var people5 = Person.getSortedNames();
        var peopleArray2 = people5.toArray(new String[0]);
        for (var person : peopleArray2) {
            System.out.println(person);
        }



    }
}
