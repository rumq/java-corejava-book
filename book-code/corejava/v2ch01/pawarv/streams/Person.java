package pawarv.streams;

import java.util.List;

public record Person(String name, String country) {

    public static List<Person> getPersons() {
        var names = List.of(
            new Person("Adam", "US"),
            new Person("Adam", "US"),
            new Person("Bella", "US"),
            new Person("Charlie", "UK"),
            new Person("David", "UK"),
            new Person("Anand", "India"),
            new Person("Brahma", "India"),
            new Person("Mia", "Albania"),
            new Person("Nina", "Albania"));
        return names;
    }
}
