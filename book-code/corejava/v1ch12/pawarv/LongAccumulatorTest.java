package pawarv;

import java.util.concurrent.atomic.LongAccumulator;

public class LongAccumulatorTest {
    public static void main(String[] args) {
        // LongAccumulator(long identity, LongBinaryOperator op)

        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);

        System.out.println("accumulator = " + accumulator.get());
        accumulator.accumulate(10);
        System.out.println("accumulator = " + accumulator.get());

    }
}
