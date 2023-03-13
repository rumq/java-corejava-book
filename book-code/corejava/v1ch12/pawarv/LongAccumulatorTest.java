package pawarv;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorTest {
    public static void main(String[] args) {

        // AtomicLong
        AtomicLong value = new AtomicLong();
        System.out.println("value = " + value.getAndAccumulate(10, (x, y) -> x + y));
        System.out.println("value = " + value.get());

        // LongAccumulator
        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        System.out.println("accumulator = " + accumulator.get());
        accumulator.accumulate(10);
        System.out.println("accumulator = " + accumulator.get());

    }
}
