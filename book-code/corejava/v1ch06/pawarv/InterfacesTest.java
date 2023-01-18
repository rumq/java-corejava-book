package pawarv;

import java.nio.file.Path;
import java.util.Collection;

public class InterfacesTest {
    public static void main(String[] args) {

        // implementation of interface using anonymous class
        var pizza = new Pizza() {
            @Override
            public void prepare() {
                System.out.println("Preparing pizza - Margherita" + " with weight < " + MAX_WEIGHT );
            }
        };

        // calling implementation of abstract method
        pizza.prepare();
        // calling implementation of static method
        Pizza.print();
        // calling implementation of default method
        System.out.println(pizza.getDescription());
    
        // implementation of interface using class
        var pineapplepizza = new PineapplePizza();
        pineapplepizza.prepare();
                

    };


}

interface Pizza {
    // demo of static variable
    double MAX_WEIGHT = 1000.00;

    // demo of abstract method
    void prepare();

    // demo of static method
    static void print() {
        System.out.println("Pizza - From static method");
    }

    // demo of default method
    default String getDescription() {
        return prepareDescription();
    }

    // demo of private method
    private String prepareDescription() {
        return "Pizza - From private method";
    }

    
}

class PineapplePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing pizza - PineapplePizza" + " with weight < " + MAX_WEIGHT );
    }
}
