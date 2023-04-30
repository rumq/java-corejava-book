package pawarv;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

    private static final int INT_COUNT = 10;
    private static final int TASK_COUNT = 2;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        
        // Create an executor 
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Keep a list of tasks
        var tasks = new ArrayList<Callable<Long>>();
        
        // Create tasks
        for (int i = 0; i < TASK_COUNT; i++) {

            // Create a task
            // This is a lambda expression that returns a Callable<Long>
            // The implemented method take nothing and returns a Long
            // It adds up all the integers from 0 to INT_COUNT
            
            Callable<Long> task = () -> {
                long sum = 0;
                for (int j = 0; j < INT_COUNT; j++) {
                    sum += j;
                }
                return sum;
            };
            tasks.add(task);
        }

        Instant startTime = Instant.now();
        List<Future<Long>> results = executor.invokeAll(tasks);
        long total = 0;
        for (Future<Long> result : results) {
            total += result.get();
        }
        Instant endTime = Instant.now();

        System.out.println("Time elapsed: " + (endTime.toEpochMilli() - startTime.toEpochMilli()));
        System.out.println("Total: " + total);
        
        executor.shutdown();

    }

}
