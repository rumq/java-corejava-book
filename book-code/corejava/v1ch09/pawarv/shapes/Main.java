package pawarv.shapes;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put("India", "New Delhi");
        countries.put("USA", "Washington DC");
        countries.put("UK", "London");

        countries.put("France", "Paris");
        countries.put("Germany", "Berlin");
        countries.put("Italy", "Rome");

        List<Map.Entry<String, String>> list = new ArrayList<>(countries.entrySet());
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}