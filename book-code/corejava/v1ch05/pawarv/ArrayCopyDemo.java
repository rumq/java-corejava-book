package pawarv;

public class ArrayCopyDemo {
    
    public static void main(String[] args) {

        // 5 element int array
        int[] a = {1,2,3,4,5};
        // 5 element int array
        int[] b = new int[5];

        // Copy 5 elements from a to b
        System.arraycopy(a, 0, b, 0, 5);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        // 5 element int array
        int[] c = new int[5];
        // Copy 2 elements from a to c
        System.arraycopy(a, 0, c, 0, 2);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
