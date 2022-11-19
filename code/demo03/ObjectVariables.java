package demo03;

public class ObjectVariables {
    public static void main(String[] args) {

        Person rob = new Person("Rob");
        Person smith = rob;
        System.out.println(rob.getName());
        System.out.println(smith.getName());

    }
}
