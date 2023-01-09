package pawarv;

import java.util.Arrays;
import java.util.Comparator;

public class MethodReferencesTest {
    public static void main(String[] args) {
 
        // Method reference to a static method : String::compareToIgnoreCase
        Comparator<String> comp = String::compareToIgnoreCase;
        System.out.println(comp.compare("Java", "java"));

        // Method reference to an static method : Polygon::compareBySides
        Comparator<Polygon> comp2 = Polygon::compareBySides;   // Method reference to a static method
        System.out.println(comp2.compare(new Polygon(3), new Polygon(4)));

        // Method reference to an static method : Polygon::compareBySides
        var polygons = new Polygon[] { new Polygon(81), new Polygon(31), new Polygon(61) };
        Arrays.sort(polygons, Polygon::compareBySides);  // Method reference to a static method 

        for (Polygon p : polygons) {
            System.out.println(p);
        }

        // Equivalent call using lambda expression;
        var polygons2 = new Polygon[] { new Polygon(82), new Polygon(32), new Polygon(62) };
        Arrays.sort(polygons2, (a, b) -> Polygon.compareBySides(a, b));  // Equivalent call using lambda expression;
        for (Polygon p : polygons2) {
            System.out.println(p);
        }

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


        // Method reference object::instanceMethod
        Polygon p = new Polygon(5);
        p.draw(x -> System.out.println("Enhanced: " + x));
        p.draw(x -> System.out.println(x));
        p.draw(System.out::println); //is equivalent to p.draw(x -> System.out.println(x));
 
 
 
        p.check(x -> System.out.println(x));
        // var polygons3 = new Polygon[] { new Polygon(83), new Polygon(33), new Polygon(63) };
        // Arrays.sort(polygons3, Comparator.comparingInt(Polygon::getSides));
        // for (Polygon p : polygons3) {
        //     System.out.println(p);
        // }
    }
}

class Polygon {
    
    private int sides;

    Polygon(int sides) {
        this.sides = sides;
    }

    public static int compareBySides(Polygon a, Polygon b) {
        return a.getSides() - b.getSides();
    }

    public int getSides() {
        return sides;
    }

    public int compareToPolygon(Polygon p) {
        return this.sides - p.getSides();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Polygon with " + sides + " sides";
    }

    
    public void draw(Enhancer e ) {
        e.enhance(toString());        
    }

    public void check(Checker c) {
        c.doCheck(this);
    }

    
}

interface Enhancer {
    void enhance(String s);
}

interface Checker {
    void doCheck(Polygon p);
}