package pawarv;

public class BasicThreadTest {
    public static void main(String[] args) {

        // 1. Implementing Runnable interface
        Runnable r = () -> {

            for (int i = 1; i < 10; i++)
                System.out.println("From " + Thread.currentThread().getName() + " :" + i);
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 20; i++)
                    System.out.println("From " + Thread.currentThread().getName() + " :" + i);
            }
        };

        // 2. Creating a threads
        Thread t = new Thread(r);
        Thread t2 = new Thread(r2);

        // 3. Starting a thread
        t.start();
        t2.start();

        // Main thread
        for (int i = 100; i <= 110; i++)
            System.out.println("From " + Thread.currentThread().getName() + " :" + i);
    }
}
