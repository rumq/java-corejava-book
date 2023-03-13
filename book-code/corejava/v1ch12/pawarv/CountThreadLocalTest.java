package pawarv;

public class CountThreadLocalTest {

    private static Integer classCount = 0;
    private static ThreadLocal<Integer> threadLocalCount = ThreadLocal.withInitial(() -> 0);
    private static Object lock = new Object();
    private  Integer objectCount = 0;

    public static void main(String[] args) throws InterruptedException {

        CountThreadLocalTest sharedObject  = new CountThreadLocalTest();
        
        Runnable r = () -> {
            CountThreadLocalTest localObject = new CountThreadLocalTest();
            var name = Thread.currentThread().getName();

            synchronized (lock) {          
                localObject.objectCount = localObject.objectCount + 1;
                sharedObject.objectCount = sharedObject.objectCount + 1;      
                 
                threadLocalCount.set(threadLocalCount.get() + 1);
                classCount = classCount + 1;
            }
            System.out.println(name + ": localObjectCount " +  localObject.objectCount + ":" + localObject);
            System.out.println(name + ": threadLocalCount " + threadLocalCount.get());
            System.out.println(name + ": sharedObjectCount " + sharedObject.objectCount + ":" + sharedObject);
            System.out.println(name + ": classCount : " + classCount);
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
