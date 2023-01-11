package pawarv;

import java.util.Arrays;

/*
 * Method reference to an instance method
 * 
 * Method reference to an instance method is of the form: object::instanceMethod
 * 
 * The method reference is equivalent to a lambda expression that calls the instance method on the object.
 *  
 */
public class MRStaticReferenceToInstanceMethodTest {
    public static void main(String[] args) {
        // Method reference to an instance method : Polygon::compareTo
        var polygons3 = new Polygon[] { new Polygon(83), new Polygon(33), new Polygon(63) };
        Arrays.sort(polygons3, Polygon::compareToPolygon); // Method reference to an instance method

        for (Polygon p : polygons3) {
            System.out.println(p);
        }

        // Equivalent call using lambda expression;
        var polygons4 = new Polygon[] { new Polygon(84), new Polygon(34), new Polygon(64) };
        Arrays.sort(polygons4, (a, b) -> a.compareToPolygon(b)); // Equivalent call using lambda expression;

        for (Polygon p : polygons4) {
            System.out.println(p);
        }
    }
}
