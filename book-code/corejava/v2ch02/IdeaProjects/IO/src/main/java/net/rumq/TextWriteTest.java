package net.rumq;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");

        try (var out = new PrintWriter("out.txt", StandardCharsets.UTF_8);) {
            out.println("First Line");
        }

    }
}
