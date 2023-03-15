package pawarv;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicLoggingTest {

    public static void main(String[] args) {

        // Get the global logger to configure it
        Logger.getGlobal().info("First Greeting - Hello");

        // Set the logging level to OFF and
        Logger.getGlobal().setLevel(Level.OFF);
        // This message won't be logged
        Logger.getGlobal().info("Second Greeting - Hello");

        Logger.getGlobal().setLevel(Level.INFO);
        // This message will be logged
        Logger.getGlobal().info("Third Greeting - Hello");

        System.out.println("BEFORE: " + Logger.getGlobal().getLevel());



    }
    
}
