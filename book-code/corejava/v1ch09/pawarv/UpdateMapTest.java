package pawarv;

import java.util.HashMap;

public class UpdateMapTest {
    public static void main(String[] args) {
        var counts = new HashMap<String, Integer>() {{
            put("Adam", 5);
            put("Bella", 6);
            put("Cindy", 3);
        }};

        // Update a value in a map using put when the key exists
        counts.put("Adam", counts.get("Adam") + 1);

        System.out.println(counts);

        // Update a value in a map using put when the key does not exist - Option 1
        counts.put("David", counts.getOrDefault("David", 0) + 1);

        System.out.println(counts);

        // Update a value in a map using put when the key does not exist - Option 2
        counts.putIfAbsent("Ethan", 0);
        counts.put("Ethan", counts.get("Ethan") + 1);
        System.out.println(counts);

        // Update a value in a map using merge 1
        counts.merge("Farhan", 1, (oldValue, newValue) -> oldValue + newValue);

        System.out.println(counts);

        // Update a value in a map using merge 2
        counts.merge("Farhan", 1, Integer::sum);

        System.out.println(counts);

        // Update a value in a map using merge 3
        counts.merge("Adam", 1, Integer::sum);

        System.out.println(counts);

    }
}
