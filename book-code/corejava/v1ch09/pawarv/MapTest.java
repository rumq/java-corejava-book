package pawarv;

public class MapTest {
    public static void main(String[] args) {
        // Get a map
        var people = Person.getPeopleMap();
        System.out.println("\n***people: " + people);

        // Get a single value from a map
        System.out.println("\n***get " + people.get("Alia"));

        // Add a new value to a map      
        people.put("George", new Person("George"));

        // Update a value in a map
        people.put("Alia", new Person("Amanda"));        
        System.out.println("\n***people: " + people);
        
        // Remove a value from a map
        people.remove("George");
        System.out.println("\n***people: " + people);

        // Get a set of keys
        var keys = people.keySet();
        System.out.println("\n***Keys: " + keys);

        // Get a set of values
        var values = people.values();

        System.out.println("\n***Values: " + values);

        // Get a set of entries
        var entries = people.entrySet();
        System.out.println("\n***Entries: " + entries);

        // Iterate over a map
        entries.forEach(
            entry -> System.out.println(entry.getKey() + " = " + entry.getValue())
        );

        // Iterate over a map and update a value
        entries.forEach(
            entry -> {
                if (entry.getKey().equals("Alia")) {
                    entry.setValue(new Person("Ariana"));
                }
            }
        );

        // Iterate over a map and remove a value
        entries.removeIf(entry -> entry.getKey().equals("Carl"));

        System.out.println("\n***people: " + people);


    }
}

