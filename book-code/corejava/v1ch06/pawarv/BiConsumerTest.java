package pawarv;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    
    public static void main(String[] args) {
        
        BiConsumer<String,String> bi = (s1, s2) -> System.out.println(s1 + s2);

        bi.accept("Apple", "Wine");

        vineyard(bi);
    }

    static void vineyard(BiConsumer<String,String> c){
        c.accept("Grape", "Wine");
    }
}

