package other.concurrency;

import java.util.concurrent.TimeUnit;
 
public class Counter extends Thread {
 
    //instance variable
    Integer count = 0;
 
    // method where the thread execution will start
    public void run() {
        int fixed = 6;  //local variable
        
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": result=" 
                                  + performCount(fixed)); 
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }  
    }
 
    // let’s see how to start the threads
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is executing..." );
        Counter counter = new Counter();
        
        //5 threads
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(counter);
            t.start();
        }

        // Thread t = new Thread(counter);
        // t.start();

        
        
    }
    
    //multiple threads can access me concurrently
    private  int performCount(int fixed) {
        return (fixed + ++count);
    }
}