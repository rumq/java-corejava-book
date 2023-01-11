package pawarv;

import java.util.Arrays;

/*
 * 
 * Done in class
 * 
 */
public class Methodreferences2Test {
    public static void main(String[] args) {

        var names = new String[] { "Harry", "Carl", "Tony" };
        
        for (String name : names) {
            System.out.println(name);
        }

        // Arrays.sort(names, (first, second) -> first.compareToIgnoreCase(second));

        // Arrays.sort(names, String::compareToIgnoreCase);
        Arrays.sort(names, String::compareTo);
        
        System.out.println("**************************");

        for (String name : names) {
            System.out.println(name);
        }
    }
    
}
