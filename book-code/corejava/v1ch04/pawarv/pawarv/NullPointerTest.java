package pawarv;


import java.util.Objects;

public class NullPointerTest {
    public static void main(String[] args) {
        String name = null;
        
        // Throws NullPointerException
        try {
            name.length();
        } catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        // Solution 1 A - check for null and set a default value
        var validatedName = name != null ? name : "unknown";    
        System.out.println(validatedName.length());

        // Solution 1 B - check for null and set a default value
        var validatedName2 = Objects.requireNonNullElse(name, "unknown");
        System.out.println(validatedName2.length());

        // Solution 2 - check for null and throw an exception

        try {            
           var validatedName3 = Objects.requireNonNull(name, "name cannot be null");
           System.out.println(validatedName3.length());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        


    }
}
