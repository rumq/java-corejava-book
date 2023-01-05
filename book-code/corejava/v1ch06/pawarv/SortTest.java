package pawarv;

import java.util.Arrays;

public class SortTest {
    
    
    public static void main(String[] args) {
        var names = new String[] { "Harry", "Carl", "Tony" };

        Arrays.sort(names);

        for (String name : names) {
            System.out.println(name);
        }
        
    }
}
