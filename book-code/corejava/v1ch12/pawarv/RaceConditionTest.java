package pawarv;

public class RaceConditionTest {

    private static class Counter {
        private int value = 0;

        // private synchronized void increment(){
        private void increment(){
            value = value + 1 ;
        }

        public int getValue() {
            return value;
        }

        public void incrementThousand() {
            for (int i = 0; i < 1000000; i++) {
                increment();
                // System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + value);
            }
        }

    }

    public static void main(String[] args) {
        final Counter counter = new Counter();

        Thread t1 = FirstThread(counter);
        Thread t2 = SecondThread(counter);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter value: " + counter.getValue());
    }

    static Thread FirstThread(Counter counter) {
        Runnable r1 = new Runnable() {
            public void run() {
                counter.incrementThousand();
            }
        };

        Thread t1 = new Thread(r1);
        return t1;
    }

    static Thread SecondThread(Counter counter) {
        Runnable r2 = new Runnable() {
            public void run() {
                counter.incrementThousand();
            }
        };

        Thread t2 = new Thread(r2);
        return t2;
    }

}
