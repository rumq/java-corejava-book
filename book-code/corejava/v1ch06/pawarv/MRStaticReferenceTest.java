package pawarv;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Method reference to an static method
 * 
 * Method reference to an static method is of the form: Class::staticMethod
 * 
 */
public class MRStaticReferenceTest {
    public static void main(String[] args) {
        // Method reference to an static method
        Comparator<Polygon> comp2 = GeoUtils::compareBySides; // Method reference to a static method
        System.out.println(comp2.compare(new Polygon(3), new Polygon(4)));

        // Method reference to an static method
        var polygons = new Polygon[] { new Polygon(81), new Polygon(31), new Polygon(61) };
        Arrays.sort(polygons, GeoUtils::compareBySides); // Method reference to a static method

        for (Polygon p : polygons) {
            System.out.println(p);
        }

        // Equivalent call using lambda expression;
        var polygons2 = new Polygon[] { new Polygon(82), new Polygon(32), new Polygon(62) };
        Arrays.sort(polygons2, (a, b) -> GeoUtils.compareBySides(a, b)); // Equivalent call using lambda expression;
        for (Polygon p : polygons2) {
            System.out.println(p);
        }

    }
}
