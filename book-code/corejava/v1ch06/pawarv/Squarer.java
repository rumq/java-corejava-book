package pawarv;

/*
 *  Demo of a singleton class
 * 
 */
public final class Squarer {

    private static Squarer INSTANCE;


    private Squarer() {
        System.out.println("Squarer constructor called");
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

    public static void main(String[] args) {
        Squarer squarer = Squarer.getInstance();
        Squarer squarer2 = Squarer.getInstance();
        Squarer squarer3 = Squarer.getInstance();
        

    }
    
}

