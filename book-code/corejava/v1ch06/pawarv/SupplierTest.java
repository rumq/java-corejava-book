package pawarv;

import java.util.Objects;

public class SupplierTest {
    public static void main(String[] args) {

        var dummy1 = new Dummy("dummy");

        // Without using Supplier, Dummy is created even if it is not required
        var dummy2a = Objects.requireNonNullElse(null, new Dummy("dummy2a"));   
        var dummy2b = Objects.requireNonNullElse(dummy1, new Dummy("dummy2b"));

        // Using Supplier, Dummy is created only if it is required
        var dummy3a = Objects.requireNonNullElseGet(null, () -> new Dummy("dummy3a")); // dummy3a is not created
        var dummy3b = Objects.requireNonNullElseGet(dummy1, () -> new Dummy("dummy3b"));

    }
}

class Dummy {
    public Dummy(String name) {
        System.out.println(name + "created");
    }

}
