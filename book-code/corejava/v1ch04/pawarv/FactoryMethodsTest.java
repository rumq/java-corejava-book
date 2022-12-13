package pawarv;

import java.text.NumberFormat;
import java.time.LocalDate;

public class FactoryMethodsTest {
    public static void main(String[] args) {

        // LocalDate.now() factory method
        var ld =  LocalDate.now();
        System.out.println(ld);

        // LocalDate.of() factory method
        var ld2 = LocalDate.of(2021, 1, 1);
        System.out.println(ld2);

        // Currency format factory method
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println(currencyFormat.format(1000000));
        
        // Percentage format factory method
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        System.out.println(percentFormat.format(0.1));

    }
}
