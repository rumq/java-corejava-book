package pawarv;

public class CovariantDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = e1.getBuddy();

        Manager m1 = new Manager();
        Manager m2 = m1.getBuddy();
    }
    
}

class Employee{
    Employee getBuddy(){
        System.out.println("Employee getBuddy");
        return new Employee();
    }

}

class Manager extends Employee{

    // Return type is different but it is covariant return type
    // method signature is same as Employee.getBuddy()
    @Override
    Manager getBuddy(){
        System.out.println("Manager getBuddy");
        return new Manager();
    }

}
