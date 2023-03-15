package pawarv;

import java.time.Instant;
import java.util.EmptyStackException;
import java.util.Stack;

public class TipExceptionDoesntReplaceTest {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        System.out.println(stack);

        long t1 = System.currentTimeMillis();
        long i1 = Instant.now().toEpochMilli();
        for (int i = 0; i < 10000; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        long t2 = System.currentTimeMillis();
        long i2 = Instant.now().toEpochMilli();

        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("EmptyStackException");
        }

        long t3 = System.currentTimeMillis();
        long i3 = Instant.now().toEpochMilli();

        System.out.println("Time taken by if: " + (t2 - t1));
        System.out.println("Time taken by try: " + (t3 - t2));
        System.out.println("Time taken by if: " + (i2 - i1));
        System.out.println("Time taken by try: " + (i3 - i2));

    }
}
