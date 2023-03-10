package pawarv;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionReentrantLockTest {

    public static void main(String[] args) {
        final CounterB counter = new CounterB();

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
        System.out.println("CounterB value: " + counter.getValue());
    }

    static Thread firstThread(CounterB counter) {
        Runnable r1 = new Runnable() {
            public void run() {
                counter.incrementLargeNumber();
            }
        };

        Thread t1 = new Thread(r1);
        return t1;
    }

    static Thread secondThread(CounterB counter) {
        Runnable r2 = new Runnable() {
            public void run() {
                counter.incrementLargeNumber();
            }
        };

        Thread t2 = new Thread(r2);
        return t2;
    }

}

class CounterB {
    private Lock lock = new ReentrantLock();
    private int value = 0;

    // private void increment(){
    //     value = value + 1 ;
    // }

    private void increment() {
        lock.lock();
        try {
            value = value + 1;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return value;
    }

    public void incrementLargeNumber() {
        for (int i = 0; i < 100000; i++) {
            increment();
            // System.out.println("Thread: " + Thread.currentThread().getName() + " Value: "
            // + value);
        }
    }

}