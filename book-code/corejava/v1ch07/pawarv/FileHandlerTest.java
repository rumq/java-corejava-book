package pawarv;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class FileHandlerTest {

    private static final Logger logger = Logger.getLogger(FileHandlerTest.class.getName());
    
    public static void main(String[] args) throws SecurityException, IOException {
        var handler = new FileHandler();

        logger.addHandler(handler);
        logger.info("Hello");
        

    }
}
