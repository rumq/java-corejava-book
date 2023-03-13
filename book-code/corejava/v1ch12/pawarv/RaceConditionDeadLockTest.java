package pawarv;

import java.time.Instant;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionDeadLockTest {

    public static void main(String[] args)  {
        final CounterF counter = new CounterF();

        Thread t1 = firstThread(counter);
        Thread t2 = secondThread(counter);
        t1.start();
        t2.start();

        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("CounterF value: " + counter.getValue());
    }

    static Thread firstThread(CounterF counter) {
        Runnable r1 = new Runnable() {
            public void run() {
                counter.incrementLargeNumber();
            }
        };

        Thread t1 = new Thread(r1);
        t1.setName("firstThread");
        return t1;
    }

    static Thread secondThread(CounterF counter) {
        Runnable r2 = new Runnable() {
            public void run() {
                counter.incrementLargeNumber();
            }
        };

        Thread t2 = new Thread(r2);
        t2.setName("secondThread");
        return t2;
    }

}

class CounterF {
    private Lock lock;
    
    private int value;

    private Condition condition;

    private long start;

    // private void increment(){
    //     value = value + 1 ;
    // }

    CounterF() {        
        value = 0;
        lock = new ReentrantLock();

        // A) Create a condition object
        condition = lock.newCondition();
        start = Instant.now().toEpochMilli();
    }
    
    private void increment()  {
        
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " : Locked");
        try {
            // while (elapsedTime() < 5){
            while (value < 1){

                // B) await
                // System.out.println(Thread.currentThread().getName() + ": Waiting");
                System.out.println(Thread.currentThread().getName() + ": Awaiting");
                condition.await();
                System.out.println(Thread.currentThread().getName() + ": Awaiting done");

            }
            System.out.println(Thread.currentThread().getName() + " : adding 1 to value");
            value = value + 1;

        // C) Catch exception
        } catch (InterruptedException e) {            
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " : Unlocking");
            lock.unlock();
        }
    }

    private long elapsedTime() {
        // D) signalAll
        System.out.println(Thread.currentThread().getName() + " : Signalling");
        condition.signalAll();
        return Instant.now().toEpochMilli() - start;
    }

    public void setValue(int i) {
        value = i;
        
    }

    public int getValue() {
        return value;
    }

    public void incrementLargeNumber() {
        for (int i = 0; i < 3; i++) {
            increment();
      
        }
    }

}