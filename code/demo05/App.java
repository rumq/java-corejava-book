package demo05;

public class App {
    public static void main(String[] args) {
        Person alan = new Person("alan");
        System.out.println(alan);
        System.out.println(alan.getName());

        Person ben = new Programmer("Ben");
        System.out.println(ben.getName());

    }
}
