package pawarv;

import java.math.BigInteger;

public class MethodChaining {
    
    public static void main(String[] args) {
        String input = "  7643264284632843847239847 ";
        
        // usual
        BigInteger bigInt = new BigInteger(input.strip());
        boolean isPrime1 = bigInt.isProbablePrime(20);
        System.out.println(isPrime1);

        // method chaining
        boolean isPrime2 = input.strip().transform(BigInteger::new).isProbablePrime(20);
    
        System.out.println(isPrime2);
    }



}
