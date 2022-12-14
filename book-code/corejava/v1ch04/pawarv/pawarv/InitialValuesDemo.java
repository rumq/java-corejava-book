package pawarv;

public class InitialValuesDemo {

    public static String s1 = "";
    public static String s2 = "Hello";
    public  String s3 ;
    public  String s4 = "Hello from field";
    
    int i1 ; //field initial value is 0


    public static void main(String[] args) {

        int i5 = 0; // Get compiler error if not initialized
        System.out.println(s1);
        System.out.println(s2);
        var iv = new InitialValuesDemo();
        System.out.println(iv.s3);
        System.out.println(iv.s4);
        System.out.println(iv.i1);
        System.out.println(i5);

    }
}
