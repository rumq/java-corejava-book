package pawarv;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * 
 *  Demonstrates the use of BlockingQueue
 *  One producer thread and multiple consumer threads
 *  Increase the number of consumer threads to see the difference
 */
public class BasicBlockingQueueTest {
    public static final String LAST_MESSAGE = "LAST_MESSAGE";
    public static final int NO_OF_MESSAGES = 1000;

    private static final int NO_OF_CONSUMER_THREADS = 10;
    private static final int QUEUE_CAPACITY = 1;

    public static void main(String[] args) throws InterruptedException {

        var q = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);

        // Start the producer thread
        Producer p = new Producer(q);
        Thread pt = new Thread(p);
        pt.start();
        
        // start time
        long start = System.currentTimeMillis();

        // Start the consumer threads
        for (int i = 0; i < NO_OF_CONSUMER_THREADS; i++) {
            new Thread(new Consumer(q)).start();
        }

        // Wait for the producer thread to finish
        boolean done = false;
        while (!done) {            
            String msg = q.peek();
            if (LAST_MESSAGE.equals(msg)) {
                done = true;
            }            
        }

        // end time
        long end = System.currentTimeMillis();

        // Print the time taken
        System.out.println("Time taken: " + (end - start)/1000.0 + " seconds");

    }
}

class Producer implements Runnable {
    
    private static int count = 0;
    private final BlockingQueue<String> queue;

    Producer(BlockingQueue<String> q) {
        queue = q;
    }

    public void run() {
        try {
            int count = 0;
            while (count++ < BasicBlockingQueueTest.NO_OF_MESSAGES) {
                queue.put(produce());
            }
            queue.put(BasicBlockingQueueTest.LAST_MESSAGE);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    String produce() {
        return new String("Hello " + count++);
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    Consumer(BlockingQueue<String> q) {
        queue = q;
    }

    public void run() {
        try {
            boolean done = false;
            while (!done) {
                String msg = queue.take();
                if (BasicBlockingQueueTest.LAST_MESSAGE.equals(msg)) {
                    done = true;
                    // Put the last message back in the queue
                    // so that other consumer threads can also
                    // exit
                    queue.put(BasicBlockingQueueTest.LAST_MESSAGE);
                } else
                    consume(msg);

                // To slow down the consumer threads
                Thread.sleep(5);                    
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    void consume(String x) {
        System.out.println(x);
    }
}
