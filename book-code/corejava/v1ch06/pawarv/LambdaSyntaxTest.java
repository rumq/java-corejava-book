package pawarv;

import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaSyntaxTest {
    public static void main(String[] args) {

        // Explicitly typed parameters
        Comparator<String> comp1 = (String first, String second) -> first.length() - second.length();
        int result1 = comp1.compare("Amitabh", "Bachan");
        System.out.println(result1);

        // compiler can infer the type of the parameters
        Comparator<String> comp2 = (first, second) -> first.length() - second.length();
        int result2 = comp2.compare("Amitabh", "Bachan");
        System.out.println(result2);

        // Single parameter with inferred type, so parentheses are optional
        // instead of (event) -> . . . or (ActionEvent event) -> . . .
        ActionListener listener = event -> System.out.println("The time is " + Instant.ofEpochMilli(event.getWhen()));

        var timer = new Timer(1000, listener);

        timer.start();

        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
        


    }
}
