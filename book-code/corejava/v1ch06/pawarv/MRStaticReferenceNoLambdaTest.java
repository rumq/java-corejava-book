package pawarv;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Method reference to an static method
 * 
 * Method reference to an static method is of the form: Class::staticMethod
 * 
 */
public class MRStaticReferenceNoLambdaTest {
    public static void main(String[] args) {

        // Method reference to an static method
        var polygons = new Polygon[] { new Polygon(81), new Polygon(31), new Polygon(61) };
        // Arrays.sort(polygons, GeoUtils::compareBySides); // Method reference to a static method
        Arrays.sort(polygons, new PolygonComparator()); // Method reference to a static method

        for (Polygon p : polygons) {
            System.out.println(p);
        }

    }
}

class PolygonComparator implements  Comparator<Polygon>  {
    @Override
    public int compare(Polygon a, Polygon b) {
        return GeoUtils.compareBySides(a, b);
    }
}
