package pawarv;

import java.util.Arrays;

public class MathTest {
    
    /*
     * 
     */
    public static void main(String[] args) {
        
            
        int[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println("************* sum");
        var total = Arrays.stream(ints).sum();       
        System.out.println(total);

        // System.out.println("************* Print");
        Arrays.stream(ints).forEach(System.out::println);

        System.out.println("************* Map");
        Arrays.stream(ints).map(x -> x * x).forEach(System.out::println);

        System.out.println("************* Utils.square");
        Arrays.stream(ints).map(Utils::square).forEach(System.out::println);
     
        System.out.println("************* Cube");
        Arrays.stream(ints).map(Utils::cube).forEach(System.out::println);

        System.out.println("************* Squarer");
        
        Squarer squarer = Squarer.getInstance();
      

        Arrays.stream(ints).map(squarer::square).forEach(System.out::println);

        
    }


}


class Utils {
    public static int square(int x) {
        return x * x;
    }

    public static int cube(int x) {
        return x * x * x;
    }
}
