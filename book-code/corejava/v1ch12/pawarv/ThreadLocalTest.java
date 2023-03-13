package pawarv;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocalCount = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        threadLocalCount.set(threadLocalCount.get() + 1);
        System.out.println("ThreadLocalTest.main() " + threadLocalCount.get());

        threadLocalCount.set(threadLocalCount.get() + 1);
        System.out.println("ThreadLocalTest.main() " + threadLocalCount.get());

    }
}
