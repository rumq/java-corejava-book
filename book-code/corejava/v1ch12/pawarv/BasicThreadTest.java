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

        // 2. Creating  threads
        Thread t = new Thread(r);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(new RunnableDemo());

        // 3. Starting threads
        t.start();
        t2.start();
        t3.start();

        // Main thread
        for (int i = 101; i < 110; i++)
            System.out.println("From " + Thread.currentThread().getName() + " :" + i);
    }

}

class RunnableDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i < 30; i++)
            System.out.println("From " + Thread.currentThread().getName() + " :" + i);
    }
}
