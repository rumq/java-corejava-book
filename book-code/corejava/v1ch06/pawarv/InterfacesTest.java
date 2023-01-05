package pawarv;

public class InterfacesTest {
    public static void main(String[] args) {
        var pizza = new Pizza() {
            @Override
            public void prepare() {
                System.out.println("Preparing pizza - Margherita" + " with weight < " + MAX_WEIGHT );
            }
        };
        pizza.prepare();
    
        var pineapplepizza = new PineapplePizza();
        pineapplepizza.prepare();
        

    };


}

interface Pizza {
    double MAX_WEIGHT = 1000.00;
    void prepare();
}

class PineapplePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing pizza - PineapplePizza" + " with weight < " + MAX_WEIGHT );
    }
}
