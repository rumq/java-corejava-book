package pawarv;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.time.Instant;

/*
 * This program demonstrates the use of super::greet method reference
 * 
 * 
 */
class GreeterTest {
    public static void main(String[] args) {

        Greeter greeter = new RepeatedGreeter();
        greeter.greet(new ActionEvent("Hello", 1, "Hello"));
        JOptionPane.showMessageDialog(null, "Quit program?");   
        System.exit(0);

    }
}

class Greeter {

    public void greet(ActionEvent event) {
        System.out.println("Hello, the time is "
                + Instant.ofEpochMilli(event.getWhen()));

    }

}

class RepeatedGreeter extends Greeter {
    public void greet(ActionEvent event) {
        var timer = new Timer(1000, super::greet); // super::greet is a method reference
        timer.start();
    }
}