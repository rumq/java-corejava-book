package pawarv;

import java.util.Comparator;

/*
 * This program demonstrates the use of lambda expressions that can access
 * free variables from the enclosing scope. But these have to be effectively
 * final. See `text` and `count` in `repeatMessage` method.
 * 
 * It also demonstrates that the parameters of a lambda expression cannot
 * redefine the parameters of the enclosing scope. See `first`
 *  
 */
public class VariableScopeTest {

    String name = "VariableScopeTest";

    public  void repeatMessage(String text, int count) {

        // Uncommenting the following line will cause a compiler error
        // text = "Changeit";
        // count = 5;

        Runnable r = () -> {
            for (int i = 0; i < count; i++) {  // `count` is a free variable
                // text = "Changeit"; // can't change `text`. This is not allowed
                System.out.println(text + " from " + this.name); // `text` is a free variable & `this` refers to VariableScopeTest object
            }
        };
        new Thread(r).start();
    }

    public static void main(String[] args) {

        var vst = new VariableScopeTest();

        vst.repeatMessage("Hello", 10);

        // Uncommenting the following line will cause a compiler error
        // String first = "Hello";
        Comparator<String> comp = (first, second) -> Integer.compare(first.length(), second.length());
    }
}
