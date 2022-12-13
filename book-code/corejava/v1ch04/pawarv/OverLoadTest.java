package pawarv;

public class OverloadTest {

    void burden(String string){
        System.out.println(string);
    }
    private void burden(boolean b) {
        System.out.println(b);
    }


    // private void burden(char c) {
    //     System.out.println(c);
    // }

    private void burden(double d) {
        System.out.println(d);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        OverloadTest odt = new OverloadTest();
        odt.burden(1);
        odt.burden(1.0);
        odt.burden(1.0f);
        odt.burden(1L);
        odt.burden((short)1);
        odt.burden((byte)1);

        // Comment and uncomment line numbers 13-15 to see that a different method is called
        odt.burden('1');


        odt.burden(true);
        odt.burden("1");

        var numberOne = '1';

        System.out.println(numberOne);
        
    }

}
