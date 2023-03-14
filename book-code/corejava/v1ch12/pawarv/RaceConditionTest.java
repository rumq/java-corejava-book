package pawarv;

public class RaceConditionTest {

    public static void main(String[] args) {
        final CounterA counter = new CounterA();

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
        System.out.println("CounterA value: " + counter.getValue());
    }

    static Thread firstThread(CounterA counter) {
        Runnable r1 = new Runnable() {
            public void run() {
                counter.incrementLargeNumber();
            }
        };

        Thread t1 = new Thread(r1);
        return t1;
    }

    static Thread secondThread(CounterA counter) {
        Runnable r2 = new Runnable() {
            public void run() {
                counter.incrementLargeNumber();
            }
        };

        Thread t2 = new Thread(r2);
        return t2;
    }

}

class CounterA {
    private volatile int value = 0;  // no use of volatile
    // private int value = 0;

    private  void increment(){
    // private void increment(){
        value = value + 1 ;
    }

    public int getValue() {
        return value;
    }

    public void incrementLargeNumber() {
        for (int i = 0; i < 1000; i++) {
            increment();
            // System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + value);
        }
    }

}