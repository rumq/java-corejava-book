package pawarv;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static AtomicInteger value = new AtomicInteger(0);
    public static void main(String[] args) {

        
        System.out.println("value = " + value.get());
        System.out.println("value = " + value.incrementAndGet());
        System.out.println("value = " + value.getAndIncrement());
        System.out.println("value = " + value.get());
        System.out.println("value = " + value.decrementAndGet());
        System.out.println("value = " + value.getAndDecrement());
        System.out.println("value = " + value.get());
        System.out.println("value = " + value.addAndGet(10));
        //getAndAdd(int delta)
        //compareAndSet(int expect, int update)
        System.out.println("value = " + value.compareAndSet(10, 20));
        System.out.println("value = " + value.get());
        //accumulateAndGet(int x, IntBinaryOperator accumulatorFunction)
        System.out.println("value = " + value.accumulateAndGet(10, (x, y) -> x + y));
        System.out.println("value = " + value.accumulateAndGet(10, (x, y) -> x * y));
        //getAndUpdate(IntUnaryOperator updateFunction)
        System.out.println("value = " + value.getAndUpdate(x -> x + 10));
        System.out.println("value = " + value.get());




    }
}
