package pawarv;


/*
 *  Demonstrates the use of on-demand initialization.
 *  The OnDemandInitializationHolder class is loaded (only once)
 *  when getInstance() is called 
 */
public class OnDemandInitializationTest {

   // Should not throw any exception
    private OnDemandInitializationTest() {
        System.out.println("OnDemandInitializationTest.<init>()");
    }

    public static OnDemandInitializationTest getInstance() {
        return InnerHolder.INSTANCE;
    }

    private class InnerHolder {
        // The static final field is initialized only when the class is loaded
        static final OnDemandInitializationTest INSTANCE = new OnDemandInitializationTest();
    }

    public static void main(String[] args) {
        var one = getInstance();
        var two = getInstance();
        System.out.println(one == two);
    }
}
