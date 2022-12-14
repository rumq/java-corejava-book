package pawarv;


public  class ImmutableTest {
    private final String name;

    public final String  getName() {
        return name;
    }

    public final int getLength() {
        return name.length();
    }

    ImmutableTest(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        var it = new ImmutableTest("Immutable Test 1");
        System.out.println(it.getName());
    }
}
