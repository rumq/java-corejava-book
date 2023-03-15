package pawarv;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdvancedLoggingTest {

    // Get the logger for this class
    // store in a static field to prevent it from being garbage collected

    private static final Logger logger = Logger.getLogger(AdvancedLoggingTest.class.getName());

    public static void main(String[] args) {

        logger.info("First Greeting - Hello");
        logger.severe("Test");
        logger.fine("Test fine"); // This message won't be logged
        

    }
}
