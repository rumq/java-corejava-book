package pawarv;

public class RaceConditionTest {

    private static class Counter {
        private int value = 0;

        public void increment() {
            value++;
        }

        public void decrement() {
            value--;
        }

        public int getValue() {
            return value;
        }

        public void decrementThousand() {
            for (int i = 0; i < 1000; i++) {
                decrement();
            }
        }

        public void incrementThousand() {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        }

    }

    public static void main(String[] args) {
        final Counter counter = new Counter();

        Thread t1 = incrementingThread(counter);
        Thread t2 = decrementingThread(counter);
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

    static Thread incrementingThread(Counter counter) {
        Runnable r1 = new Runnable() {
            public void run() {
                counter.incrementThousand();
            }
        };

        Thread t1 = new Thread(r1);
        return t1;
    }

    static Thread decrementingThread(Counter counter) {
        Runnable r2 = new Runnable() {
            public void run() {
                counter.decrementThousand();
            }
        };

        Thread t2 = new Thread(r2);
        return t2;
    }

}
