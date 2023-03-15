package pawarv;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleHandlersTest {

    private static final Logger logger = Logger.getLogger(ConsoleHandlersTest.class.getName());

    public static void main(String[] args) {
        System.out.println("***********BEFORE: " + logger.getLevel());

        logger.warning("Warning");
        logger.severe("Severe");
        logger.info("Info");
        logger.config("Config"); // This message won't be logged
        logger.fine("Fine"); // This message won't be logged
        logger.finer("Finer"); // This message won't be logged
        logger.finest("Finest"); // This message won't be logged

        // Add a console handler to the logger
        // and set it to the ALL level
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false); // comment to see double output for levels SEVERE and above
        var handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        System.out.println("*************AFTER: " + logger.getLevel());

        logger.warning("Warning");
        logger.severe("Severe");
        logger.info("Info");
        logger.config("Config");
        logger.fine("Fine");
        logger.finer("Finer");
        logger.finest("Finest");
    }
}
