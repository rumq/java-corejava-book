package pawarv;

import java.util.Objects;

public class SupplierTest {
    public static void main(String[] args) {

        var dummy1 = new Dummy("dummy1");

        // Without using Supplier, Dummy is created even if it is not required
        var dummy2a = Objects.requireNonNullElse(null, new Dummy("dummy2a"));   
        System.out.println(dummy2a);
        var dummy2b = Objects.requireNonNullElse(dummy1, new Dummy("dummy2b"));
        System.out.println(dummy2b);
        

        System.out.println("**************************");
        // Using Supplier, Dummy is created only if it is required (Lazy evaluation)
        var dummy3a = Objects.requireNonNullElseGet(null, () -> new Dummy("dummy3a")); // dummy3a is not created
        System.out.println(dummy3a);
        var dummy3b = Objects.requireNonNullElseGet(dummy1, () -> new Dummy("dummy3b"));
        System.out.println(dummy3b);

    }
}

class Dummy {
    String name;
    public Dummy(String name) {
        this.name = name;
        System.out.println(name + "created");
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  name;
    }

}
