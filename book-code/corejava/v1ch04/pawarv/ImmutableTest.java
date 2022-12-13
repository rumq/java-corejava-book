package pawarv;

public class ImmutableTest {
    private final String name;

    public String getName() {
        return name;
    }

    ImmutableTest(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        var it = new ImmutableTest("Immutable Test 1");
        System.out.println(it.getName());
    }
}
