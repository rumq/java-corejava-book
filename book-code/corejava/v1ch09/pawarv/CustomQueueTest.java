package pawarv;

import java.util.*;

public class CustomQueueTest {

    public static void main(String[] args) {
        var queue = new CustomQueue<String>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        queue.offer("E");
        queue.offer("F");
        queue.offer("G");


        System.out.println(queue);
        System.out.println("Peeking : " + queue.peek());
        queue.poll();
        System.out.println("Peeking again: " + queue.peek());

 
        System.out.println("\n***********Iterating over elements . . .");
        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println("\n***********Removing elements . . .");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println("\n*********Checking if the queue is empty . . .");
        System.out.println(queue);
    }
}
