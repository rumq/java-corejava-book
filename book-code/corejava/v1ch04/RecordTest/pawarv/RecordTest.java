package pawarv;

public class RecordTest {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Employee rahul = new Employee("Rahul", 100000);
        System.out.println(rahul.name());
        System.out.println(rahul.salary());

    }
}

record Employee(String name, double salary) { }