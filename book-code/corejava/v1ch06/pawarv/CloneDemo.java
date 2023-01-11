package pawarv;

public class CloneDemo {
  public static void main(String[] args) throws CloneNotSupportedException {

    var original = new Employee("New");

    // clone creates a new object
    Employee copy = original.clone();
    System.out.println(original == copy ? "same" : "different");

    // alias points to the same object
    Employee alias = original;
    System.out.println(original == alias ? "same" : "different");
  }
}

class Employee implements Cloneable {
  String name;

  public String getName() {
    return name;
  }

  public Employee(String name) {
    this.name = name;
  }

  public Employee clone() throws CloneNotSupportedException {

    return (Employee) super.clone();
  }

  public static void main(String[] args) {
    var e1 = new Employee("New");
    System.out.println(e1.getName());
  }
}
