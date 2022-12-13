package pawarv;


public class OverloadOverriddenTest  {
    public static void main(String[] args) {
        
        var rabbit = new Rabbit();
        rabbit.eats();

        var monkey = new OverriddenMonkey();
        monkey.eats();

        var donkey = new OverloadedDonkey();

        donkey.eats(" grass");


    }
}

class OverriddenMonkey extends Animal {

    @Override  // This is an override
    void eats() {
        System.out.println("OverriddenMonkey eats banana");
    }
}

class OverloadedDonkey extends Animal {

    // @Override   // This is not an override, it is an overload
    void eats(String food) {
        System.out.println("OverloadedDonkey eats" + food);
    }

}
    
class Rabbit extends Animal {
}
    
class Animal {


    void eats() {
        System.out.println("Animal eats food");
    }
}

