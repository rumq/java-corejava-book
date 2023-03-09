package pawarv;

/*
 *  Demonstrates the use of Thread.interrupt() and Thread.isInterrupted()
 * 
 *  Thread.interrupt() sets the interrupted status of the thread to true.
 *  
 *  A sleeping thread can be interrupted by calling interrupt() on the thread object.
 *  The interrupted status of the thread is cleared when an InterruptedException is thrown.
 * 
 *  
 */
public class InterruptTest {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    System.out.println("Thread 1: Run once, and going to sleep for 1 seconds" );
                    Thread.sleep(1000);
                    System.out.println("Thread 1: Woke up after 1 seconds");
                } catch (InterruptedException e) {

                    // The interrupted status of the thread is cleared when an InterruptedException is thrown.
                    System.out.println(
                            "Thread 1 : Thread.ecurrentThread().isInterrupted() : " + Thread.currentThread().isInterrupted()); // false
                    System.out.println("Thread 1 : Interrupted While sleeping");
                }
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread 2 is running - INSIDE WHILE");
                }
                System.out.println("Thread 2 is running - OUTSIDE WHILE");
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        System.out.println("BEFORE t1.isInterrupted() " + t1.isInterrupted());
        System.out.println("BEFORE t2.isInterrupted() " + t2.isInterrupted());
        System.out.println("Interrupting t1");
        t1.interrupt();  // Uncomment this line to see the difference
        System.out.println("Interrupting t2");
        t2.interrupt();
        System.out.println("AFTER t1.isInterrupted() " + t1.isInterrupted()); // false - InterruptedException thrown (flag cleared)
        System.out.println("AFTER t2.isInterrupted() " + t2.isInterrupted()); // true 

        System.out.println("Out of main");
    }
}
