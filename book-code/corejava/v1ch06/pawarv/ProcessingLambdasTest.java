package pawarv;

import java.util.function.IntConsumer;

/*
 * This program demonstrates how to write methods
 * that process lambda expressions
 * 
 */
public class ProcessingLambdasTest {

    public static void main(String[] args) {
     
        repeat(10, () -> System.out.println("Hello, World!"));

        repeatCountDown(10, i -> System.out.println("Countdown: " + (9 - i)));
    }

    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++)
            action.run();
    }

    public static void repeatCountDown(int n, IntConsumer action){
        for (int i = 0; i < n; i++)
            action.accept(i);

        action.accept(100);
    }
}
