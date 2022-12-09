package innerClass;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;

    }

    class InnerEmployee {
        public void print() {
            System.out.println("InnerEmployee.print() called");
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee("Harry", 50000);
        InnerEmployee i = e.new InnerEmployee();
        i.print();
    }
}
