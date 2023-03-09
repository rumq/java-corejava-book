package pawarv;

public class InterruptedTest {
    public static void main(String[] args) {

        Runnable r2 = new Runnable() {

            public void run() {

                System.out.println("Thread.interrupted() 1 : " + Thread.interrupted());

                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread 2 is running - INSIDE WHILE");
                }
                System.out.println("Thread.interrupted() 2 : " + Thread.interrupted()); //  reports true & clears
                System.out.println("Thread.interrupted() 3 : " + Thread.interrupted()); // reports false
                System.out.println("Thread 2 is running - OUTSIDE WHILE");
            }
        };

        Thread t2 = new Thread(r2);
        t2.start();
        System.out.println("BEFORE t2.isInterrupted() " + t2.isInterrupted());

        t2.interrupt();
        // System.out.println("AFTER t1.isInterrupted() " + t1.isInterrupted()); //
        // false - InterruptedException thrown (flag cleared)
        System.out.println("AFTER t2.isInterrupted() " + t2.isInterrupted()); // true

    }
}
