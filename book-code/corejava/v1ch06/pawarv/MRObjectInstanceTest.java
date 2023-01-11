package pawarv;

public class MRObjectInstanceTest {
    public static void main(String[] args) {

        // Method reference object::instanceMethod
        Polygon p = new Polygon(5);
        p.draw(System.out::println); // is equivalent to p.draw(x -> System.out.println(x));
        p.draw(x -> System.out.println("Enhanced: " + x)); // lambda has to be used if the method reference is not
                                                           // possible

        p.check(x -> System.out.println(x));
    }
}

