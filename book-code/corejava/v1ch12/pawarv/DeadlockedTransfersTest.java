package pawarv;

import java.util.concurrent.atomic.AtomicInteger;

public class DeadlockedTransfersTest {
    // private static final int TIMES = 1;
    private static final int TIMES = 1000;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {

        final Account a = new Account(1000);
        final Account b = new Account(1000);

        Thread t1 = new Thread() {
            public void run() {
                System.out.println("t1 - running");
                for (int i = 0; i < TIMES; i++)
                    transfer(a, b, 100);
            }
        };

        Thread t2 = new Thread() {

            public void run() {
                System.out.println("t2 - running");
                for (int i = 0; i < TIMES; i++)
                    transfer(b, a, 100);
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("a = " + a.getBalance());
        System.out.println("b = " + b.getBalance());

    }

    public static void transfer(Account from, Account to, int amount) {
        
        synchronized (from) {
            synchronized (to) {
                System.out.println(count.incrementAndGet() + ":" + Thread.currentThread().getName() + " - transfering " + amount + " from " + from + " to " + to );

                from.debit(amount);
                to.credit(amount);

            }
        }
    }

}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void debit(int amount) {
        balance -= amount;
    }

    public void credit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
