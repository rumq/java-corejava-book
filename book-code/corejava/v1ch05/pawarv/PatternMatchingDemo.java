package pawarv;

public class PatternMatchingDemo {

    public static void main(String[] args) {
        Object obj = "Hello";        
        Object obj2 = Integer.parseInt("10");

        
        // Checks if obj2 is instance of Integer
        if (obj2 instanceof Integer) {
            Integer i = (Integer) obj2;
            System.out.println(i);
        }
        
        // Checks if obj2 is instance of Integer, and assigns it to i if true (pattern matching)
        if (obj2 instanceof Integer i) {            
            System.out.println(i);
        }

        // Similar to above, but with String
        if (obj instanceof String s) {
            System.out.println(s.substring(1));
        }
    }
}