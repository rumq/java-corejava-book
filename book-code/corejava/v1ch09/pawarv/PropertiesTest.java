package pawarv;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {

        // Create a properties object
        var props = new Properties();

        // Set properties
        props.setProperty("userName", "vp2");
        props.setProperty("database", "Oracle");

        // Get properties
        System.out.println(props.getProperty("userName"));
        System.out.println(props.getProperty("database"));

        // Store properties
        var out = new FileWriter("props.properties");
        props.store(out, "Properties file");

        // Load properties
        var propsIn = new Properties();
        var in = new FileReader("props.properties");
        propsIn.load(in);

        // Get properties
        System.out.println("*** Properties loaded from file");
        System.out.println(propsIn.getProperty("userName"));
        System.out.println(propsIn.getProperty("database"));

    }

}
