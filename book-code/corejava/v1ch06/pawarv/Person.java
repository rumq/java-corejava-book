package pawarv;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Person> getPeople() {
        var people = new ArrayList<Person>();
        people.add(new Person("Diana"));
        people.add(new Person("Alia"));
        people.add(new Person("Carl"));
        people.add(new Person("Bob"));
        people.add(new Person("Fiona"));       
        people.add(new Person("Ethan"));
        return people;
    }
}
