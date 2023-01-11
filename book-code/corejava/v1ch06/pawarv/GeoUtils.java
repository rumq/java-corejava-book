package pawarv;

public class GeoUtils {

    public static int compareBySides(Polygon a, Polygon b) {
        return a.getSides() - b.getSides();
    }

    
}

interface Enhancer {
    void enhance(String s);
}

interface Checker {
    void doCheck(Polygon p);
}