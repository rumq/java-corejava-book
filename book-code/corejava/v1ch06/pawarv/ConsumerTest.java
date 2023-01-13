package pawarv;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
    
        Consumer<String> single = s -> System.out.println(s);

        Consumer<String> duplicate = s -> System.out.println(s + s);

        single.accept("Banana - once");

        single.andThen(single).andThen(single).accept("Banana");

        single.andThen(duplicate).accept("Apple");
        
        vineyard(s -> System.out.println(s));
        vineyard(s -> System.out.println("Eating " + s));
        vineyard(s -> System.out.println("Making wine with  " + s));

        orchard(s -> System.out.println("Eating " + s));
    }

    static void vineyard(Consumer<String> c){
        c.accept("Grape");
    }
    static void orchard(Consumer<String> c){
        c.andThen(c).accept("Orange");
    }
}
