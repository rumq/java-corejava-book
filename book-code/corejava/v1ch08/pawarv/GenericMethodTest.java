package pawarv;

import genericAlgorithms.Pair;
/*
 *  Demonstrates the use of generic methods
 *  
 *  Generic method is a method that declares 
 *  one or more type parameters between 
 *  the modifiers and the return type.
 * 
 *  Note that this class has a generic method, 
 *  but is not a generic class.
 * 
 * 
 */
public class GenericMethodTest {
    
    public static void main(String[] args) {
        Pair<String> mm = new Pair<>("first", "second");
        System.out.println("min = " + mm.getFirst());

        Pair<Integer> mm1 = new Pair<>();
        System.out.println("Has Nulls Pair<Integer> = " + hasNulls(mm1));

        Pair<String> mm2 = new Pair<>("first", null);
        System.out.println("Has Nulls Pair<String> = " + hasNulls(mm2));

        // Can also call the generic method like this
        var result1 = GenericMethodTest.<String>hasNulls(mm2);
        var result2 = GenericMethodTest.hasNulls(mm2);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

        
    }

    // Generic method
    public static  <T> boolean hasNulls (Pair<T> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

}
