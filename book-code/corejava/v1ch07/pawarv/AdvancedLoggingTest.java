package pawarv;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AdvancedLoggingTest {

    // Get the logger for this class
    // store in a static field to prevent it from being garbage collected

    
    private static final Logger logger1 = Logger.getLogger(AdvancedLoggingTest.class.getName());
    private static final Logger childLogger = Logger.getLogger("Anything.is.ok");
    private static final Logger parentLogger = Logger.getLogger("Anything.is");
    private static final Logger grandParentLogger = Logger.getLogger("Anything");
    

    public static void main(String[] args) {
        System.out.println(AdvancedLoggingTest.class.getName());

        logger1.info("First Greeting - Hello");
        logger1.severe("Test");
        logger1.fine("Test fine"); // This message won't be logged

        childLogger.info("From Child Anything is ok");
        parentLogger.info("From Parent Anything is");
        grandParentLogger.info("From Grand Parent Anything");

        grandParentLogger.setLevel(Level.OFF);

        System.out.println("**** After grand parent set to: " + grandParentLogger.getLevel());
        childLogger.info("From Child Anything is ok");
        parentLogger.info("From Parent Anything is");
        grandParentLogger.info("From Grand Parent Anything");

        grandParentLogger.setLevel(Level.INFO);
        System.out.println("**** After grand parent set to: " + grandParentLogger.getLevel());
        childLogger.info("From Child Anything is ok");
        parentLogger.info("From Parent Anything is");
        grandParentLogger.info("From Grand Parent Anything");


        

    }
}
