package pawarv;

import java.util.Objects;

public class TipNullAndIndexTest {
    public static void main(String[] args) {

        String greeting = "Hello";
        // String greeting = null;
        Objects.requireNonNull(greeting, "s is null");

        String[] strings = new String[10];
        strings[0] = greeting;
        Objects.checkIndex(0, strings.length);
        Objects.checkFromToIndex(0, 10, strings.length);
        Objects.checkFromIndexSize(0, 10, strings.length);

    }
}
