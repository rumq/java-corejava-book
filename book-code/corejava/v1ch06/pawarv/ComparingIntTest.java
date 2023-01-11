package pawarv;

import java.util.Arrays;
import java.util.Comparator;

public class ComparingIntTest {
    public static void main(String[] args) {
        var polygons3 = new Polygon[] { new Polygon(83), new Polygon(33), new Polygon(63) };
        Arrays.sort(polygons3, Comparator.comparingInt(Polygon::getSides));
        for (Polygon p : polygons3) {
            System.out.println(p);
        }

    }
}
