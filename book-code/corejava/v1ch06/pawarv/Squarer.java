package pawarv;

public final class Squarer {

    private static Squarer INSTANCE;


    private Squarer() {
    }

    public static Squarer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Squarer();
        }
        return INSTANCE;
    }

    int square(int x) {
        return x * x;
    }
    
}
