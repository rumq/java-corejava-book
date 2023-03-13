package pawarv;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionAtomicIntegerTest {

    public static void main(String[] args) {
        final CounterE counter = new CounterE();

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
        System.out.println("CounterE value: " + counter.getValue());
    }

    static Thread firstThread(CounterE counter) {
        Runnable r1 = new Runnable() {
            public void run() {
                counter.incrementLargeNumber();
            }
        };

        Thread t1 = new Thread(r1);
        t1.setName("firstThread");
        return t1;
    }

    static Thread secondThread(CounterE counter) {
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

class CounterE {
    // private int value = 0;
    // private synchronized void increment(){
    // private void increment(){
    // value = value + 1 ;
    // }
    // public int getValue() {
    // return value;
    // }

    private AtomicInteger value = new AtomicInteger(0);

    private void increment() {
        value.incrementAndGet();
    }
    public AtomicInteger getValue() {
        return value;
    }

    public void incrementLargeNumber() {
        for (int i = 0; i < 1000000; i++) {
            increment();
        }
    }

}