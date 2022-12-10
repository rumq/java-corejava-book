package pawarv;

public class RecordTest {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SaneEmployee rahul = new SaneEmployee("Rahul", 100000);
        System.out.println(rahul.name());
        System.out.println(rahul.salary());

        // CrazyEmployee crazyRahul = new CrazyEmployee("Rahul", 100000);
        // System.out.println(crazyRahul.name());
        // System.out.println(crazyRahul.salary());

        CrazyEmployee crazyRahul2 = new CrazyEmployee("Rahul", 2000000);

        System.out.println(crazyRahul2.name());


    }
}

record SaneEmployee(String name, double salary) { }
record CrazyEmployee(String name, double salary) {

    public CrazyEmployee {
        if (salary < 1000000) {
            throw new IllegalArgumentException("Salary must be >= 1000000");
        }
    }

    public String name() {
        return "Ginormously Crazy " + name;
    }
 }