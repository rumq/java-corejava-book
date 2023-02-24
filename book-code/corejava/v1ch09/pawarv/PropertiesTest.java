package pawarv;

import java.io.File;
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
        props.list(System.out);

        // Get properties with default
        System.out.println(props.getProperty("queueName", "defaultQueue"));

        // Store properties
        String userDir = System.getProperty("user.home");
        var propsDir = new File(userDir, ".corejava");
        if (!propsDir.exists()) {
            propsDir.mkdir();
        }
        File propsFile = new File(propsDir, "props.properties");
        var out = new FileWriter(propsFile);
        
        props.store(out, "Properties file");

        // Load properties
        var propsIn = new Properties();
        var in = new FileReader(propsFile);
        propsIn.load(in);

        // Get properties
        System.out.println("*** Properties loaded from file");
        System.out.println(propsIn.getProperty("userName"));
        System.out.println(propsIn.getProperty("database"));

        // Create a new properties object form existing properties as default
        var newProps = new Properties(props);
        newProps.setProperty("userName", "vp3");
        newProps.list(System.out);

        // System properties
        System.out.println("*** System properties");

        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));

        Properties systemProperties = System.getProperties();
        systemProperties.list(System.out);

    }

}
