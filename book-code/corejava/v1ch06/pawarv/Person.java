package pawarv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return name.length();
    }

    private String name;

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }

    public static List<String> getSortedNames() {
        List<String> names = getNames();
        names.sort(String::compareToIgnoreCase);
        return names;
    }
    public static List<String> getNames() {
        var names = new ArrayList<String>();
        names.add("Diana");
        names.add("Bob");
        names.add("Alia");
        names.add("Carl");
        names.add("Ethan");
        names.add("Fiona");        
        return names;
    }

    public static List<Person> getPeopleList() {
        var people = new ArrayList<Person>();
        people.add(new Person("Diana"));
        people.add(new Person("Alia"));
        people.add(new Person("Carl"));
        people.add(new Person("Bob"));
        people.add(new Person("Fiona"));       
        people.add(new Person("Ethan"));
        return people;
    }

    // A way to convert a list to an array
    public static Person[] getPeopleArray() {
        return getPeopleList().toArray(new Person[0]);
    }

    public static Map<String, Person> getPeopleMap() {
        var people = new HashMap<String, Person>();
        people.put("Diana", new Person("Diana"));
        people.put("Alia", new Person("Alia"));
        people.put("Carl", new Person("Carl"));
        people.put("Bob", new Person("Bob"));
        people.put("Fiona", new Person("Fiona"));       
        people.put("Ethan", new Person("Ethan"));
        return people;
    }
}
